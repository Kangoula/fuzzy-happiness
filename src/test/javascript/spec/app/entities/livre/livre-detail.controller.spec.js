'use strict';

describe('Controller Tests', function() {

    describe('Livre Management Detail Controller', function() {
        var $scope, $rootScope;
        var MockEntity, MockPreviousState, MockLivre, MockExemplaire, MockEmprunt, MockAuteur;
        var createController;

        beforeEach(inject(function($injector) {
            $rootScope = $injector.get('$rootScope');
            $scope = $rootScope.$new();
            MockEntity = jasmine.createSpy('MockEntity');
            MockPreviousState = jasmine.createSpy('MockPreviousState');
            MockLivre = jasmine.createSpy('MockLivre');
            MockExemplaire = jasmine.createSpy('MockExemplaire');
            MockEmprunt = jasmine.createSpy('MockEmprunt');
            MockAuteur = jasmine.createSpy('MockAuteur');
            

            var locals = {
                '$scope': $scope,
                '$rootScope': $rootScope,
                'entity': MockEntity,
                'previousState': MockPreviousState,
                'Livre': MockLivre,
                'Exemplaire': MockExemplaire,
                'Emprunt': MockEmprunt,
                'Auteur': MockAuteur
            };
            createController = function() {
                $injector.get('$controller')("LivreDetailController", locals);
            };
        }));


        describe('Root Scope Listening', function() {
            it('Unregisters root scope listener upon scope destruction', function() {
                var eventType = 'bibalDenisApp:livreUpdate';

                createController();
                expect($rootScope.$$listenerCount[eventType]).toEqual(1);

                $scope.$destroy();
                expect($rootScope.$$listenerCount[eventType]).toBeUndefined();
            });
        });
    });

});
