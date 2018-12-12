var app = angular.module("springDemo", []);

app.controller("AppCtrl", function($scope) {
    $scope.websites = [{
        iconImageUrl: '',
        id: 'stackoverflow',
        website: 'stackoverflow.com',
        title: 'StackOverflow title',
        description: 'StackOverflow description'
    }];

    $http.get('http://localhost:8080/api/stackoverflow').success(function(data) {
        $scope.websites = data;
    });
});