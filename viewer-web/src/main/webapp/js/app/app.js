'use strict';

var app = angular.module('app', [
    'ngRoute',
    'ngAnimate',
    'route-segment',
    'ui.select',
    'ui.bootstrap',
    'ngSanitize',
    'ngTable',
    'admin'
]);

// configure our routes
app.config(function ($routeProvider, $locationProvider) {
    $routeProvider

    // route for the home page
        .when('/', {
            templateUrl: 'index.jsp',
            controller: 'appController'
        });
});

angular.module('admin',[]);

app.directive('ngEnter', function () {
    return function (scope, element, attrs) {
        element.bind("keydown keypress", function (event) {
            if (event.which === 13) {
                scope.$apply(function () {
                    scope.$eval(attrs.ngEnter);
                });

                event.preventDefault();
            }
        });
    };
});
