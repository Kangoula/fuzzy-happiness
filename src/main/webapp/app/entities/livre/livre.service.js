(function() {
    'use strict';
    angular
        .module('bibalDenisApp')
        .factory('Livre', Livre);

    Livre.$inject = ['$resource', 'DateUtils'];

    function Livre ($resource, DateUtils) {
        var resourceUrl =  'api/livres/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                        data.dateEdition = DateUtils.convertLocalDateFromServer(data.dateEdition);
                        data.dateAjout = DateUtils.convertLocalDateFromServer(data.dateAjout);
                    }
                    return data;
                }
            },
            'update': {
                method: 'PUT',
                transformRequest: function (data) {
                    var copy = angular.copy(data);
                    copy.dateEdition = DateUtils.convertLocalDateToServer(copy.dateEdition);
                    copy.dateAjout = DateUtils.convertLocalDateToServer(copy.dateAjout);
                    return angular.toJson(copy);
                }
            },
            'save': {
                method: 'POST',
                transformRequest: function (data) {
                    var copy = angular.copy(data);
                    copy.dateEdition = DateUtils.convertLocalDateToServer(copy.dateEdition);
                    copy.dateAjout = DateUtils.convertLocalDateToServer(copy.dateAjout);
                    return angular.toJson(copy);
                }
            }
        });
    }
})();
