(function() {
    'use strict';
    angular
        .module('bibalDenisApp')
        .factory('Emprunt', Emprunt);

    Emprunt.$inject = ['$resource', 'DateUtils'];

    function Emprunt ($resource, DateUtils) {
        var resourceUrl =  'api/emprunts/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                        data.dateEmprunt = DateUtils.convertLocalDateFromServer(data.dateEmprunt);
                        data.dateRetour = DateUtils.convertLocalDateFromServer(data.dateRetour);
                    }
                    return data;
                }
            },
            'update': {
                method: 'PUT',
                transformRequest: function (data) {
                    var copy = angular.copy(data);
                    copy.dateEmprunt = DateUtils.convertLocalDateToServer(copy.dateEmprunt);
                    copy.dateRetour = DateUtils.convertLocalDateToServer(copy.dateRetour);
                    return angular.toJson(copy);
                }
            },
            'save': {
                method: 'POST',
                transformRequest: function (data) {
                    var copy = angular.copy(data);
                    copy.dateEmprunt = DateUtils.convertLocalDateToServer(copy.dateEmprunt);
                    copy.dateRetour = DateUtils.convertLocalDateToServer(copy.dateRetour);
                    return angular.toJson(copy);
                }
            }
        });
    }
})();
