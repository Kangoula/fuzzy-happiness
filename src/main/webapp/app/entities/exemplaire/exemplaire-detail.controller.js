(function() {
    'use strict';

    angular
        .module('bibalDenisApp')
        .controller('ExemplaireDetailController', ExemplaireDetailController);

    ExemplaireDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Exemplaire', 'Livre', 'Magazine'];

    function ExemplaireDetailController($scope, $rootScope, $stateParams, previousState, entity, Exemplaire, Livre, Magazine) {
        var vm = this;

        vm.exemplaire = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('bibalDenisApp:exemplaireUpdate', function(event, result) {
            vm.exemplaire = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
