(function() {
    'use strict';

    angular
        .module('bibalDenisApp')
        .controller('UsagerDialogController', UsagerDialogController);

    UsagerDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'Usager', 'Reservation', 'Emprunt'];

    function UsagerDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, Usager, Reservation, Emprunt) {
        var vm = this;

        vm.usager = entity;
        vm.clear = clear;
        vm.save = save;
        vm.reservations = Reservation.query();
        vm.emprunts = Emprunt.query();

        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.usager.id !== null) {
                Usager.update(vm.usager, onSaveSuccess, onSaveError);
            } else {
                Usager.save(vm.usager, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('bibalDenisApp:usagerUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }


    }
})();
