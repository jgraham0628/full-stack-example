Vue.component('facilities-list', {
    template: '<div id="dialog-box-facilities-list" class="ddPopup" v-show="show">' + 
        '<div id="dialog-facilities-title" class="ddPopupTitle">Facilities Status</div>' + 
        '<div><b-table striped hover :items="facilities" :fields="fields" /></div>' + 
        '</div>',
    data() {
        return {
            fields: [
                {key: 'name', sortable: true},
                {key: 'location', sortable: true},
                {key: 'status', sortable: true}
            ],
            facilities: [],
            show: false
        }
    },
    mounted() {
        this.getFacilitiesData();
    },
    methods: {
        toggleFacilities: function() {
            this.show = !this.show;
        },
        getFacilitiesData: function() {
            this.$http
            .get('http://localhost:8080/Empire-Web/api/facilities/list')
            .then(
                response => {
                    this.facilities = response.body;
                    var list = document.createElement('facilities-list');
                    document.getElementById('container').appendChild(list);
                    dragElement(document.getElementById("dialog-box-facilities-list"), {left: 200, top: 200});
                }
            );
        }
    }
});