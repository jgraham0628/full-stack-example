var app = new Vue({
  el: '#container'
});

var headerNav = new Vue({
  el: '#navigation',
  data() {
    return {
      options: [
        {id: 'launch-facilities', name: 'Facilities'},
        {id: 'launch-operations', name: 'Operations'},
        {id: 'launch-directives', name: 'Directives'},
        {id: 'launch-personnel', name: 'Personnel'}
      ],
      username: 'Commander Kerstain'
    }
  },
  methods: {
    toggleFacilities() {
      app.$refs.facilities.toggleFacilities();
    }
  }
});