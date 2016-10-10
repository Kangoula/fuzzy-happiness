(function() {
    'use strict';

    angular
        .module('bibalDenisApp')
        .controller('LivreDetailController', LivreDetailController);

    LivreDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Livre', 'Exemplaire', 'Emprunt', 'Auteur'];

    function LivreDetailController($scope, $rootScope, $stateParams, previousState, entity, Livre, Exemplaire, Emprunt, Auteur) {
        var vm = this;

        vm.livre = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('bibalDenisApp:livreUpdate', function(event, result) {
            vm.livre = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
