'use strict';

describe('Controller Tests', function() {

    describe('Exemplaire Management Detail Controller', function() {
        var $scope, $rootScope;
        var MockEntity, MockPreviousState, MockExemplaire, MockLivre, MockMagazine, MockReservation;
        var createController;

        beforeEach(inject(function($injector) {
            $rootScope = $injector.get('$rootScope');
            $scope = $rootScope.$new();
            MockEntity = jasmine.createSpy('MockEntity');
            MockPreviousState = jasmine.createSpy('MockPreviousState');
            MockExemplaire = jasmine.createSpy('MockExemplaire');
            MockLivre = jasmine.createSpy('MockLivre');
            MockMagazine = jasmine.createSpy('MockMagazine');
            MockReservation = jasmine.createSpy('MockReservation');
            

            var locals = {
                '$scope': $scope,
                '$rootScope': $rootScope,
                'entity': MockEntity,
                'previousState': MockPreviousState,
                'Exemplaire': MockExemplaire,
                'Livre': MockLivre,
                'Magazine': MockMagazine,
                'Reservation': MockReservation
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
