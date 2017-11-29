(function () {
    angular.module('admin').controller('ViewerController',
        function ($scope, $http, $sce, $filter, NgTableParams, $uibModal) {

            $scope.trustAsHtml = function (value) {
                return $sce.trustAsHtml(value);
            };

            $scope.pzns = [];
            $http.get('common/pzns')
                .success(function (data) {
                    $scope.pzns = data;
                });

            $scope.filter = {};

            $scope.search = function () {
                $scope.bnkseeks.reload();
            };
            $scope.clear = function () {
                $scope.filter = {};
                $scope.bnkseeks.reload();
            };
            $scope.remove = function (id) {
                $http.get('remove/bnkseek', {params: {id: id}})
                    .success(function (data) {
                        $scope.bnkseeks.reload();
                    })
            };

            $scope.bnkseeks = new NgTableParams({
                page: 1,
                count: 10
            }, {
                getData: function ($defer, params) {

                    $scope.filter.fromNum = (params.page() - 1) * params.count();
                    $scope.filter.count = params.count();
                    // $scope.filter.order = params.orderBy().toString();

                    $http.post('viewer/bnkseeks', $scope.filter)
                        .success(function (data) {
                            $defer.resolve(data.list);
                            params.total(data.size);
                        });
                }
            });

            $scope.openForm = function (id) {
                $http.get('bnkseek', {params: {id: id ? id : null}}).then(function (response) {
                    var bnkseek = response.data;
                    if (bnkseek.dtIzm) {
                        bnkseek.dtIzm = new Date(bnkseek.dtIzm);
                    }
                    if (bnkseek.dateIn) {
                        bnkseek.dateIn = new Date(bnkseek.dateIn);
                    }
                    if (bnkseek.dateCh) {
                        bnkseek.dateCh = new Date(bnkseek.dateCh);
                    }

                    var modalInstance = $uibModal.open(
                        {
                            templateUrl: 'templates/viewer/edit.jsp',
                            controller: function ($scope, $http, $sce, $uibModalInstance, bnkseek) {
                                $scope.bnkseek = bnkseek;

                                $scope.pzns = [];
                                $http.get('common/pzns').success(function (response) {
                                    $scope.pzns = response;
                                });

                                $scope.uers = [];
                                $http.get('common/uers').success(function (response) {
                                    $scope.uers = response;
                                });

                                $scope.rgns = [];
                                $http.get('common/rgns').success(function (response) {
                                    $scope.rgns = response;
                                });

                                $scope.tnps = [];
                                $http.get('common/tnps').success(function (response) {
                                    $scope.tnps = response;
                                });

                                $scope.reals = [];
                                $http.get('common/reals').success(function (response) {
                                    $scope.reals = response;
                                });

                                $scope.cancel = function () {
                                    $uibModalInstance.dismiss();
                                };

                                $scope.trustAsHtml = function (value) {
                                    return $sce.trustAsHtml(value);
                                };

                                $scope.submit = function () {
                                    $http.post('bnkseek', $scope.bnkseek).success(function (response) {
                                        $uibModalInstance.dismiss();
                                    })
                                }

                            },
                            size: 'md',
                            backdrop: 'static',
                            resolve: {
                                bnkseek: function () {
                                    return bnkseek;
                                }
                            }
                        }
                    );

                    modalInstance.result.then(function () {
                        $scope.bnkseeks.reload();
                    });

                });

            }

        });
})();