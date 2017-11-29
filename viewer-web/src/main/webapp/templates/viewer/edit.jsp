<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="../../include.jsp" %>

<div class="modal-content">

    <div class="modal-header">
        <span class="modal-title modal-title-ex">
            ЭБД
        </span>
        <img ng-click="cancel()" style="cursor: pointer;float: right;" src="<c:url value="/images/close_01.gif"/> ">
    </div>

    <div class="modal-body" cg-busy="{promise:promise, message: 'Идет сохранение, пожалуйста,подождите'}">
        <form name="form" novalidate="">
            <div class="form-group">
                <label for="real">Код контроля допустимости проведения расчетных операций</label>
                <ui-select theme="bootstrap" id="real" ng-model="bnkseek.real">
                    <ui-select-match allow-clear="">
                        {{$select.selected.real}}
                    </ui-select-match>
                    <ui-select-choices repeat="real in reals | filter:$select.search">
                        <div ng-bind-html="trustAsHtml((real.real | highlight: $select.search))"></div>
                    </ui-select-choices>
                </ui-select>
            </div>

            <div class="form-group">
                <label for="pzn">Тип участника расчетов</label>
                <ui-select theme="bootstrap" id="pzn" ng-model="bnkseek.pzn">
                    <ui-select-match allow-clear="">
                        {{$select.selected.name}}
                    </ui-select-match>
                    <ui-select-choices repeat="pzn in pzns | filter:$select.search">
                        <div ng-bind-html="trustAsHtml((pzn.name | highlight: $select.search))"></div>
                    </ui-select-choices>
                </ui-select>
            </div>

            <div class="form-group">
                <label for="uer">Тип участника системы электронных расчетов</label>
                <ui-select theme="bootstrap" id="uer" ng-model="bnkseek.uer" required="true">
                    <ui-select-match allow-clear="">
                        {{$select.selected.name}}
                    </ui-select-match>
                    <ui-select-choices repeat="uer in uers | filter:$select.search">
                        <div ng-bind-html="trustAsHtml((uer.name | highlight: $select.search))"></div>
                    </ui-select-choices>
                </ui-select>
            </div>

            <div class="form-group">
                <label for="rgn">Территория</label>
                <ui-select theme="bootstrap" id="rgn" ng-model="bnkseek.rgn" required="true">
                    <ui-select-match allow-clear="">
                        {{$select.selected.name}}
                    </ui-select-match>
                    <ui-select-choices repeat="rgn in rgns | filter:$select.search">
                        <div ng-bind-html="trustAsHtml((rgn.name | highlight: $select.search))"></div>
                    </ui-select-choices>
                </ui-select>
            </div>

            <div class="form-group">
                <label for="tnp">Тип населенного пункта</label>
                <ui-select theme="bootstrap" id="tnp" ng-model="bnkseek.tnp">
                    <ui-select-match allow-clear="">
                        {{$select.selected.fname}}
                    </ui-select-match>
                    <ui-select-choices repeat="tnp in tnps | filter:$select.search">
                        <div ng-bind-html="trustAsHtml((tnp.fname | highlight: $select.search))"></div>
                    </ui-select-choices>
                </ui-select>
            </div>

            <div class="form-group">
                <label for="ind">Индекс</label>
                <input type="text" maxlength="255" class="form-control" id="ind" ng-model="bnkseek.ind">
            </div>

            <div class="form-group">
                <label for="nnp">Населенный пункт</label>
                <input type="text" maxlength="255" class="form-control" id="nnp" ng-model="bnkseek.nnp">
            </div>

            <div class="form-group">
                <label for="adr">Адрес</label>
                <input type="text" maxlength="255" class="form-control" id="adr" ng-model="bnkseek.adr">
            </div>

            <div class="form-group">
                <label for="rkc">БИК РКЦ</label>
                <input type="text" maxlength="255" class="form-control" id="rkc" ng-model="bnkseek.rkc">
            </div>

            <div class="form-group">
                <label for="namep">Наименование участника расчетов</label>
                <input type="text" maxlength="45" class="form-control" id="namep" ng-model="bnkseek.namep" required>
            </div>

            <div class="form-group">
                <label for="telef">Телефон</label>
                <input type="text" maxlength="255" class="form-control" id="telef" ng-model="bnkseek.telef">
            </div>

            <div class="form-group">
                <label for="regn">Регистрационный номер</label>
                <input type="text" maxlength="255" class="form-control" id="regn" ng-model="bnkseek.regn">
            </div>

            <div class="form-group">
                <label for="okpo">ОКПО</label>
                <input type="text" maxlength="8" class="form-control" id="okpo" ng-model="bnkseek.okpo">
            </div>

            <div class="form-group">
                <label for="dtIzm">Дата последего изменения записи</label>
                <input type="date" class="form-control" id="dtIzm" ng-model="bnkseek.dtIzm" required>
            </div>

            <div class="form-group">
                <label for="ksnp">Номер счета</label>
                <input type="text" maxlength="255" class="form-control" id="ksnp" ng-model="bnkseek.ksnp">
            </div>

            <div class="form-group">
                <label for="dateIn">Дата включения информации об участнике расчетов в ЭБД</label>
                <input type="date" class="form-control" id="dateIn" ng-model="bnkseek.dateIn" required>
            </div>

            <div class="form-group">
                <label for="dateCh">Дата контроля</label>
                <input type="date" class="form-control" id="dateCh" ng-model="bnkseek.dateCh">
            </div>

        </form>
    </div>


    <div class="modal-footer">
        <button type="button" class="btn btn-primary" ng-click="submit()" ng-disabled="form.$invalid">
            Сохранить
        </button>

        <button type="button" class="btn btn-default" ng-click="cancel()">
            Отмена
        </button>
    </div>
</div>