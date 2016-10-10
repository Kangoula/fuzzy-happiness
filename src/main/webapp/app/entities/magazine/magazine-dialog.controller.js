(function() {
    'use strict';

    angular
        .module('bibalDenisApp')
        .controller('MagazineDialogController', MagazineDialogController);

    MagazineDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'Magazine', 'Auteur', 'Exemplaire', 'Emprunt'];

    function MagazineDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, Magazine, Auteur, Exemplaire, Emprunt) {
        var vm = this;

        vm.magazine = entity;
        vm.clear = clear;
        vm.datePickerOpenStatus = {};
        vm.openCalendar = openCalendar;
        vm.save = save;
        vm.auteurs = Auteur.query();
        vm.exemplaires = Exemplaire.query();
        vm.emprunts = Emprunt.query();

        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.magazine.id !== null) {
                Magazine.update(vm.magazine, onSaveSuccess, onSaveError);
            } else {
                Magazine.save(vm.magazine, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('bibalDenisApp:magazineUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }

        vm.datePickerOpenStatus.parution = false;
        vm.datePickerOpenStatus.dateAjout = false;

        function openCalendar (date) {
            vm.datePickerOpenStatus[date] = true;
        }
    }
})();
