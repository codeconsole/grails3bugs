// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better
// to create separate JavaScript files as needed.
//
//= require jquery-2.2.0.min
//= require bootstrap
//= require angular/angular
//= require angular-resource/angular-resource
// require_tree .
//= require_self


if (typeof jQuery !== 'undefined') {
    (function($) {
        $('#spinner').ajaxStart(function() {
            $(this).fadeIn();
        }).ajaxStop(function() {
            $(this).fadeOut();
        });
    })(jQuery);
}




var demoApp = angular.module('demoApp', ['ngResource'])

demoApp.controller('DemoCtrl', function($scope, $resource) {
    var User = $resource('/users/:id.json')
    $scope.user = User.get({id:1})
    $scope.user.username = 'grails'

    $scope.save = function(){
        $scope.user.$save({id:$scope.user.id})
    }
})
