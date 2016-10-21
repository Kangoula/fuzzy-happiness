'use strict';

describe('Controller Tests', function() {

    describe('Exemplaire Management Detail Controller', function() {
        var $scope, $rootScope;
        var MockEntity, MockPreviousState, MockExemplaire, MockMagazine, MockLivre, MockEmprunt;
        var createController;

        beforeEach(inject(function($injector) {
            $rootScope = $injector.get('$rootScope');
            $scope = $rootScope.$new();
            MockEntity = jasmine.createSpy('MockEntity');
            MockPreviousState = jasmine.createSpy('MockPreviousState');
            MockExemplaire = jasmine.createSpy('MockExemplaire');
            MockMagazine = jasmine.createSpy('MockMagazine');
            MockLivre = jasmine.createSpy('MockLivre');
            MockEmprunt = jasmine.createSpy('MockEmprunt');
            

            var locals = {
                '$scope': $scope,
                '$rootScope': $rootScope,
                'entity': MockEntity,
                'previousState': MockPreviousState,
                'Exemplaire': MockExemplaire,
                'Magazine': MockMagazine,
                'Livre': MockLivre,
                'Emprunt': MockEmprunt
            };
            createController = function() {
                $injector.get('$controller')("ExemplaireDetailController", locals);
            };
        }));


        describe('Root Scope Listening', function() {
            it('Unregisters root scope listener upon scope destruction', function() {
                var eventType = 'bibalDenisApp:exemplaireUpdate';

                createController();
                expect($rootScope.$$listenerCount[eventType]).toEqual(1);

                $scope.$destroy();
                expect($rootScope.$$listenerCount[eventType]).toBeUndefined();
            });
        });
    });

});
