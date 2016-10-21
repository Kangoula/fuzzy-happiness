(function() {
    'use strict';

    angular
        .module('bibalDenisApp')
        .controller('LivreDialogController', LivreDialogController);

    LivreDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'Livre', 'Exemplaire', 'Auteur'];

    function LivreDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, Livre, Exemplaire, Auteur) {
        var vm = this;

        vm.livre = entity;
        vm.clear = clear;
        vm.datePickerOpenStatus = {};
        vm.openCalendar = openCalendar;
        vm.save = save;
        vm.exemplaires = Exemplaire.query();
        vm.auteurs = Auteur.query();

        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.livre.id !== null) {
                Livre.update(vm.livre, onSaveSuccess, onSaveError);
            } else {
                Livre.save(vm.livre, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('bibalDenisApp:livreUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }

        vm.datePickerOpenStatus.dateEdition = false;
        vm.datePickerOpenStatus.dateAjout = false;

        function openCalendar (date) {
            vm.datePickerOpenStatus[date] = true;
        }
    }
})();
