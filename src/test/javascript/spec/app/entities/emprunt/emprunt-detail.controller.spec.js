'use strict';

describe('Controller Tests', function() {

    describe('Emprunt Management Detail Controller', function() {
        var $scope, $rootScope;
        var MockEntity, MockPreviousState, MockEmprunt, MockUsager, MockLivre, MockMagazine;
        var createController;

        beforeEach(inject(function($injector) {
            $rootScope = $injector.get('$rootScope');
            $scope = $rootScope.$new();
            MockEntity = jasmine.createSpy('MockEntity');
            MockPreviousState = jasmine.createSpy('MockPreviousState');
            MockEmprunt = jasmine.createSpy('MockEmprunt');
            MockUsager = jasmine.createSpy('MockUsager');
            MockLivre = jasmine.createSpy('MockLivre');
            MockMagazine = jasmine.createSpy('MockMagazine');
            

            var locals = {
                '$scope': $scope,
                '$rootScope': $rootScope,
                'entity': MockEntity,
                'previousState': MockPreviousState,
                'Emprunt': MockEmprunt,
                'Usager': MockUsager,
                'Livre': MockLivre,
                'Magazine': MockMagazine
            };
            createController = function() {
                $injector.get('$controller')("EmpruntDetailController", locals);
            };
        }));


        describe('Root Scope Listening', function() {
            it('Unregisters root scope listener upon scope destruction', function() {
                var eventType = 'bibalDenisApp:empruntUpdate';

                createController();
                expect($rootScope.$$listenerCount[eventType]).toEqual(1);

                $scope.$destroy();
                expect($rootScope.$$listenerCount[eventType]).toBeUndefined();
            });
        });
    });

});
