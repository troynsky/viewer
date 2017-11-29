<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include.jsp" %>

<!DOCTYPE html>
<html lang="ru" ng-app="app">
<head>
    <script src="<c:url value="/js/jquery/jquery-1.12.4.min.js"/>"></script>

    <%--bootstrap--%>
    <script src="<c:url value="/bootstrap/js/bootstrap.min.js"/>"></script>
    <link href="<c:url value="/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
    <%--end bootstrap--%>

    <script src="<c:url value="/js/angular/angular-1.5.8/angular.min.js"/>"></script>
    <script src="<c:url value="/js/angular/angular-1.5.8/angular-sanitize.min.js"/>"></script>
    <script src="<c:url value="/js/angular/angular-1.5.8/angular-route.min.js"/>"></script>
    <script src="<c:url value="/js/angular/angular-1.5.8/angular-animate.min.js"/>"></script>
    <script src="<c:url value="/js/angular/angular-1.5.8/angular-touch.min.js"/>"></script>
    <script src="<c:url value="/js/angular/angular-1.5.8/angular-cookies.min.js"/>"></script>
    <script src="<c:url value="/js/angular/angular-route-segment/angular-route-segment.js"/>"></script>
    <script src="<c:url value="/js/angular/ui-bootstrap-tpls-2.5.0.min.js"/>"></script>


    <script src="<c:url value="/js/angular/ng-table/ng-table.min.js"/>"></script>
    <link href="<c:url value="/js/angular/ng-table/ng-table.min.css"/>" rel="stylesheet">

    <script src="<c:url value="/js/angular/ui-select/select.min.js"/>"></script>
    <link href="<c:url value="/js/angular/ui-select/select.min.css"/>" rel="stylesheet">

    <script src="<c:url value="/js/app/app.js"/>"></script>
    <script src="<c:url value="/js/app/controller/ViewerController.js"/>"></script>
    <link href="<c:url value="css/main.css"/>" rel="stylesheet">

</head>
<body ng-controller="ViewerController">

<div>
    <div class="row">
        <div class="col-lg-12" style="margin-bottom: 15px;">
            <h2 style="text-align: center;">Справочник БИК Банка России</h2>
        </div>
    </div>

    <div class="row">
        <div class="col-lg-12">

            <div class="col-lg-4">
                <div class="form-group">
                    <label for="bik" class="control-label col-lg-2 ">
                        БИК
                    </label>
                    <div class="col-lg-8">
                        <input class="form-control" type="number" id="bik"
                               placeholder="Укажите БИК"
                               ng-model="filter.bik"/>
                    </div>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="form-group">
                    <label for="region" class="col-lg-2 control-label">
                        Регион
                    </label>
                    <div class="col-lg-8">
                        <input type="text" id="region" maxlength="255"
                               class="form-control"
                               placeholder="Укажите регион"
                               ng-model="filter.region">
                    </div>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="form-group">
                    <label for="pzn" class="col-lg-4 control-label">
                        Тип участника расчетов
                    </label>
                    <div class="col-lg-8">
                        <div class="multiline-select">
                            <ui-select multiple theme="bootstrap" id="pzn" ng-model="filter.pzns">
                                <ui-select-match placeholder="Укажите тип участника расчетов" allow-clear="">
                                    {{$item.name}}
                                </ui-select-match>
                                <ui-select-choices repeat="pzn in pzns | filter:$select.search">
                                    <div ng-bind-html="trustAsHtml((pzn.name | highlight: $select.search))"></div>
                                </ui-select-choices>
                            </ui-select>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>

    <div class="row">
        <div class="col-lg-12" style="text-align: center; margin-top: 15px;">
            <button type="button" class="btn btn-primary" ng-click="search()">
                Найти
            </button>
            <button type="button" class="btn btn-default" ng-click="clear()">
                Очистить
            </button>
        </div>
    </div>

    <div class="row">
        <div class="col-lg-12" style="text-align: center; margin-top: 15px;">
            <button type="button" class="btn btn-primary" ng-click="openForm()">
                Добавить
            </button>
        </div>
    </div>

    <div class="row">
        <h3 class="text-center">Результаты поиска</h3>
        <div class="col-lg-12">
            <table ng-table="bnkseeks" class="table table-bordered" style="border-color: #ffffff;">
                <tr ng-repeat="item in $data track by item.id">
                    <td data-title="'Контроль допустимости'">
                        {{item.real.real}}
                    </td>
                    <td data-title="'Тип участника'">
                        {{item.pzn.name}}
                    </td>
                    <td data-title="'Участник эл.расчетов'">
                        {{item.uer.name}}
                    </td>
                    <td data-title="'Регион'">
                        {{item.rgn.name}}
                    </td>
                    <td data-title="'Тип населен.пункта'">
                        {{item.tnp.fname}}
                    </td>
                    <td data-title="'Индекс'">
                        {{item.ind}}
                    </td>
                    <td data-title="'Нас.пункт'">
                        {{item.nnp}}
                    </td>
                    <td data-title="'Адрес'">
                        {{item.adr}}
                    </td>
                    <td data-title="'ГРКЦ'">
                        {{item.rkc}}
                    </td>
                    <td data-title="'Имя участника расчетов'">
                        {{item.namep}}
                    </td>
                    <td data-title="'Бик'">
                        {{item.newnum}}
                    </td>
                    <td data-title="'Тел'">
                        {{item.telef}}
                    </td>
                    <td data-title="'Рег.номер'">
                        {{item.regn}}
                    </td>
                    <td data-title="'ОКПО'">
                        {{item.okpo}}
                    </td>
                    <td data-title="'Посл.измен.'">
                        {{item.dtIzm | date : 'dd.MM.yyyy' }}
                    </td>
                    <td data-title="'Номер счета'">
                        {{item.ksnp}}
                    </td>
                    <td data-title="'Дата включ.'">
                        {{item.dateIn | date : 'dd.MM.yyyy'}}
                    </td>
                    <td data-title="'Дата контроля'">
                        {{item.dateCh | date : 'dd.MM.yyyy'}}
                    </td>
                    <td data-title="'Действие'">
                        <span class="glyphicon glyphicon-list-alt" aria-hidden="true" style="font-size:1.5em;" ng-click="openForm(item.id)"></span>
                        <span class="glyphicon glyphicon-remove" aria-hidden="true" style="font-size:1.5em;" ng-click="remove(item.id)"></span>
                    </td>

                </tr>
                <tr>
                    <td ng-show="$data.length == 0" colspan="18">
                        <h2 class="text-center" style="color:#1b6d85;">Поиск не дал результатов</h2>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>


</body>
</html>
