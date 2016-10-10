(function() {
    'use strict';
    angular
        .module('bibalDenisApp')
        .factory('Usager', Usager);

    Usager.$inject = ['$resource'];

    function Usager ($resource) {
        var resourceUrl =  'api/usagers/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                    }
                    return data;
                }
            },
            'update': { method:'PUT' }
        });
    }
})();
