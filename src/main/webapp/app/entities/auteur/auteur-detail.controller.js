(function() {
    'use strict';

    angular
        .module('bibalDenisApp')
        .controller('AuteurDetailController', AuteurDetailController);

    AuteurDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Auteur', 'Magazine', 'Livre'];

    function AuteurDetailController($scope, $rootScope, $stateParams, previousState, entity, Auteur, Magazine, Livre) {
        var vm = this;

        vm.auteur = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('bibalDenisApp:auteurUpdate', function(event, result) {
            vm.auteur = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
