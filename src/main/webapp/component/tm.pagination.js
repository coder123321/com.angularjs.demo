/**
 * name: tm.pagination
 *
 * page 当前页
 * total 总行数
 * rows 每页行数
 * onChange 每次变更分页执行函数
 * pagesLength 显示页数
 * perPageOptions 分页数量控制
 *
 * Version: 0.0.2
 */
angular.module('tm.pagination', []).directive('tmPagination',[function(){
    return {
        restrict: 'EA',
        template: '<div class="pageConfig-div-right"><div class="page-list">' +
            '<ul class="pagination" ng-show="conf.total > 0">' +
            '<li ng-class="{disabled: conf.page == 1}" ng-click="prevPage()"><span>&laquo;</span></li>' +
            '<li ng-repeat="item in pageList track by $index" ng-class="{active: item == conf.page, separate: item == \'...\'}" ' +
            'ng-click="changeCurrentPage(item)">' +
            '<span>{{ item }}</span>' +
            '</li>' +
            '<li ng-class="{disabled: conf.page == conf.numberOfPages}" ng-click="nextPage()"><span>&raquo;</span></li>' +
            '</ul>' +
            '<div class="page-total" ng-show="conf.total > 0">' +
            '第<input type="text" ng-model="jumpPageNum"  ng-keyup="jumpToPage($event)"/>页 ' +
            '每页<select ng-model="conf.rows" ng-options="option for option in conf.pageOptions "></select>' +
            '/共<strong>{{ conf.total }}</strong>条' +
            '</div>' +
            '<div class="no-items" ng-show="conf.total <= 0">暂无数据</div>' +
            '</div></div>',
        replace: true,
        scope: {
            conf: '='
        },
        link: function(scope, element, attrs){
            // 变更当前页
            scope.changeCurrentPage = function(item) {
                if(item == '...'){
                    return;
                }else{
                    scope.conf.page = item;
                }
            };
            // 定义分页的长度必须为奇数 (default:5)
            if(scope.conf.pagesLength==undefined){
                scope.conf.pagesLength=5;
            }else{
                scope.conf.pagesLength = parseInt(scope.conf.pagesLength);
            }
            if(scope.conf.pagesLength % 2 === 0){
                // 如果不是奇数的时候处理一下
                scope.conf.pagesLength = scope.conf.pagesLength -1;
            }

            // conf.erPageOptions
            if(!scope.conf.pageOptions){
                scope.conf.pageOptions = [10, 15, 20, 30, 50];
            }

            // pageList数组
            function getPagination(newValue, oldValue) {

                // conf.page
                scope.conf.page = parseInt(scope.conf.page) ? parseInt(scope.conf.page) : 1;

                // conf.total
                scope.conf.total = parseInt(scope.conf.total) ? parseInt(scope.conf.total) : 0;

                // conf.rows (default:15)
                scope.conf.rows = parseInt(scope.conf.rows) ? parseInt(scope.conf.rows) : 15;
                

                // numberOfPages
                scope.conf.numberOfPages = Math.ceil(scope.conf.total/scope.conf.rows);

                // judge page > scope.numberOfPages
                if(scope.conf.page < 1){
                    scope.conf.page = 1;
                }

                // 如果分页总数>0，并且当前页大于分页总数
                if(scope.conf.numberOfPages > 0 && scope.conf.page > scope.conf.numberOfPages){
                    scope.conf.page = scope.conf.numberOfPages;
                }

                // jumpPageNum
                scope.jumpPageNum = scope.conf.page;

                // 如果rows在不在pageOptions数组中，就把rows加入这个数组中
                var pageOptionsLength = scope.conf.pageOptions.length;
                // 定义状态
                var pageOptionsStatus;
                for(var i = 0; i < pageOptionsLength; i++){
                    if(scope.conf.pageOptions[i] == scope.conf.rows){
                        pageOptionsStatus = true;
                    }
                }
                // 如果rows在不在pageOptions数组中，就把rows加入这个数组中
                if(!pageOptionsStatus){
                    scope.conf.pageOptions.push(scope.conf.rows);
                }

                // 对选项进行sort
                scope.conf.pageOptions.sort(function(a, b){return a-b});

                scope.pageList = [];
                if(scope.conf.numberOfPages <= scope.conf.pagesLength){
                    // 判断总页数如果小于等于分页的长度，若小于则直接显示
                    for(i =1; i <= scope.conf.numberOfPages; i++){
                        scope.pageList.push(i);
                    }
                }else{
                    // 总页数大于分页长度（此时分为三种情况：1.左边没有...2.右边没有...3.左右都有...）
                    // 计算中心偏移量
                    var offset = (scope.conf.pagesLength - 1)/2;
                    if(scope.conf.page <= offset){
                        // 左边没有...
                        for(i =1; i <= offset +1; i++){
                            scope.pageList.push(i);
                        }
                        scope.pageList.push('...');
                        scope.pageList.push(scope.conf.numberOfPages);
                    }else if(scope.conf.page > scope.conf.numberOfPages - offset){
                        scope.pageList.push(1);
                        scope.pageList.push('...');
                        for(i = offset + 1; i >= 1; i--){
                            scope.pageList.push(scope.conf.numberOfPages - i);
                        }
                        scope.pageList.push(scope.conf.numberOfPages);
                    }else{
                        // 最后一种情况，两边都有...
                        scope.pageList.push(1);
                        scope.pageList.push('...');

                        for(i = Math.ceil(offset/2) ; i >= 1; i--){
                            scope.pageList.push(scope.conf.page - i);
                        }
                        scope.pageList.push(scope.conf.page);
                        for(i = 1; i <= offset/2; i++){
                            scope.pageList.push(scope.conf.page + i);
                        }

                        scope.pageList.push('...');
                        scope.pageList.push(scope.conf.numberOfPages);
                    }
                }

                if(scope.conf.onChange){
                    // 防止初始化两次请求问题
                    if(!(oldValue != newValue && oldValue[0] == 0)) {
                        scope.conf.onChange();
                    }
                    
                }
                scope.$parent.conf = scope.conf;
            }

            // prevPage
            scope.prevPage = function(){
                if(scope.conf.page > 1){
                    scope.conf.page -= 1;
                }
            };
            // nextPage
            scope.nextPage = function(){
                if(scope.conf.page < scope.conf.numberOfPages){
                    scope.conf.page += 1;
                }
            };

            // 跳转页
            scope.jumpToPage = function(){
                scope.jumpPageNum = scope.jumpPageNum.replace(/[^0-9]/g,'');
                if(scope.jumpPageNum !== ''){
                    scope.conf.page = scope.jumpPageNum;
                }
            };

            scope.$watch(function() {
                if(!scope.conf.total) {
                    scope.conf.total = 0;
                }
                var newValue = scope.conf.total + ' ' +  scope.conf.page + ' ' + scope.conf.rows;
                return newValue;
            }, getPagination);

        }
    };
}]);
