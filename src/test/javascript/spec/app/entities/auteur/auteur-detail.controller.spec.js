'use strict';

describe('Controller Tests', function() {

    describe('Auteur Management Detail Controller', function() {
        var $scope, $rootScope;
        var MockEntity, MockPreviousState, MockAuteur, MockMagazine, MockLivre;
        var createController;

        beforeEach(inject(function($injector) {
            $rootScope = $injector.get('$rootScope');
            $scope = $rootScope.$new();
            MockEntity = jasmine.createSpy('MockEntity');
            MockPreviousState = jasmine.createSpy('MockPreviousState');
            MockAuteur = jasmine.createSpy('MockAuteur');
            MockMagazine = jasmine.createSpy('MockMagazine');
            MockLivre = jasmine.createSpy('MockLivre');
            

            var locals = {
                '$scope': $scope,
                '$rootScope': $rootScope,
                'entity': MockEntity,
                'previousState': MockPreviousState,
                'Auteur': MockAuteur,
                'Magazine': MockMagazine,
                'Livre': MockLivre
            };
            createController = function() {
                $injector.get('$controller')("AuteurDetailController", locals);
            };
        }));


        describe('Root Scope Listening', function() {
            it('Unregisters root scope listener upon scope destruction', function() {
                var eventType = 'bibalDenisApp:auteurUpdate';

                createController();
                expect($rootScope.$$listenerCount[eventType]).toEqual(1);

                $scope.$destroy();
                expect($rootScope.$$listenerCount[eventType]).toBeUndefined();
            });
        });
    });

});
