(function() {
    'use strict';

    angular
        .module('bibalDenisApp')
        .controller('MagazineDetailController', MagazineDetailController);

    MagazineDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Magazine', 'Exemplaire', 'Auteur'];

    function MagazineDetailController($scope, $rootScope, $stateParams, previousState, entity, Magazine, Exemplaire, Auteur) {
        var vm = this;

        vm.magazine = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('bibalDenisApp:magazineUpdate', function(event, result) {
            vm.magazine = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
