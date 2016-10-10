(function() {
    'use strict';

    angular
        .module('bibalDenisApp')
        .controller('MagazineDetailController', MagazineDetailController);

    MagazineDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Magazine', 'Auteur', 'Exemplaire', 'Emprunt'];

    function MagazineDetailController($scope, $rootScope, $stateParams, previousState, entity, Magazine, Auteur, Exemplaire, Emprunt) {
        var vm = this;

        vm.magazine = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('bibalDenisApp:magazineUpdate', function(event, result) {
            vm.magazine = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
