(function() {
    'use strict';

    angular
        .module('bibalDenisApp')
        .controller('EmpruntReturnController', EmpruntReturnController);

    EmpruntReturnController.$inject = ['$timeout', '$scope', '$rootScope', '$stateParams', '$uibModalInstance', 'entity', 'Emprunt', 'Usager', 'Exemplaire'];

    function EmpruntReturnController($timeout, $scope, $rootScope, $stateParams, $uibModalInstance, entity, Emprunt, Usager, Exemplaire) {
        var vm = this;

        vm.emprunt = entity;
        vm.clear = clear;
        vm.datePickerOpenStatus = {};
        vm.openCalendar = openCalendar;
        vm.save = save;
        vm.usagers = Usager.query();
        vm.exemplaires = Exemplaire.query();
        vm.usagerFullName = vm.emprunt.usager.prenom + ' ' + vm.emprunt.usager.nom;
        vm.titre = vm.emprunt.exemplaire.livre == null ? vm.emprunt.exemplaire.magazine.titre : vm.emprunt.exemplaire.livre.titre;

        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.emprunt.id !== null) {
                Emprunt.update(vm.emprunt, onSaveSuccess, onSaveError);
                if(vm.emprunt.exemplaire.id !== null){
                    Exemplaire.update(vm.emprunt.exemplaire, onSaveSuccess, onSaveError);
                    Emprunt.delete({id: vm.emprunt.id})
                }
            } else {
                Emprunt.save(vm.emprunt, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('bibalDenisApp:empruntUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }

        vm.datePickerOpenStatus.dateEmprunt = false;
        vm.datePickerOpenStatus.dateRetour = false;

        function openCalendar (date) {
            vm.datePickerOpenStatus[date] = true;
        }
    }
})();
