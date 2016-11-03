(function() {
    'use strict';

    angular
        .module('bibalDenisApp')
        .controller('EmpruntController', EmpruntController);

    EmpruntController.$inject = ['$scope', '$state', 'Emprunt'];

    function EmpruntController ($scope, $state, Emprunt) {
        var vm = this;

        vm.emprunts = [];


        var enRetard = function (item) {
            return new Date(item.dateRetour) < Date.now();
        };

        var nonEnRetard = function (item) {
            return !enRetard(item);
        };

        var someEnRetard = function(){
            return vm.emprunts.some(enRetard);
        };

        vm.enRetard = enRetard;
        vm.nonEnRetard = nonEnRetard;
        vm.someEnRetard = someEnRetard;

        loadAll();

        function loadAll() {
            Emprunt.query(function(result) {
                vm.emprunts = result;
            });
        }
    }
})();
