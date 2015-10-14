<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>个性导航</title>
    <link href="/js/bootstrap-treeview/src/css/bootstrap-treeview.css" rel="stylesheet">
    <link href="/js/metisMenu/metisMenu.min.css" rel="stylesheet">
    <link href="/js/metisMenu/demo.css" rel="stylesheet">
    <link href="/css/navigation.css" rel="stylesheet">
    <script type="text/javascript" src="/js/dragsort-0.5.2/jquery.dragsort-0.5.2.min.js"></script>
    <script type="text/javascript" src="/js/bootstrap-treeview/src/js/bootstrap-treeview.js"></script>
    <script type="text/javascript" src="/js/metisMenu/metisMenu.min.js"></script>
    <script type="text/javascript" src="/js/views/navigation.js"></script>
</head>
<body>
<div class="container" id="container-main">
    <div class="row">
        <div class="col-lg-3 rowcol-left">
            <div class="treeview-head">导航列表
                <div class="treeview-head-right">
                    <a href="#" class="treeview-head-icon-right">
                        <span id="addnavlink" class="octicon octicon-plus" data-toggle="tooltip" data-placement="top"
                              title="添加"></span>
                    </a>

                    <a href="#" class="treeview-head-icon-right">
                         <span id="editnav" class=" octicon octicon-pencil" data-toggle="tooltip"
                               data-placement="top" title="编辑"></span>
                    </a>
                </div>
            </div>
            <div id="treeview"></div>
            <div class="editdlg">
                <form>
                    <div class="form-group form-group-sm">
                        <label for="naveditname">名称</label>
                        <input type="text" class="form-control" id="naveditname">
                    </div>

                    <button type="button" class="btn btn-success">确定</button>
                    <button type="button" class="btn btn-danger" onclick="canceledit()">取消</button>
                </form>
            </div>
        </div>
        <div class="col-lg-9 rowcol-right">
            <div class="btn-search">
                <form action="http://www.baidu.com/baidu" target="_blank">
                    <div class="input-group input-group-sm">
                        <input name="tn" type="hidden" value="baidu">
                        <input type="text" class="form-control" placeholder="请输入查询内容" name="word" size="30"
                               baiduSug="1">

                        <div class="input-group-btn dropmenu">
                            <button type="submit" class="btn btn-default">搜索</button>

                            <button id="shownav4" type="button" class="btn btn-default"
                                    data-toggle="dropmenu"
                                    aria-expanded="false">操作<b
                                    class="caret"></b></button>

                            <div class="dropmenu-panel">
                                <div class="dropmenu-header">
                                    <span class="dropmenu-title">title</span>
                                        <span class="octicon octicon-x header-close" role="button"
                                              aria-label="Close"></span>
                                </div>
                                <div class="dropmenu-filters">
                                    <div class="dropmenu-filter">
                                        <input type="text" class="filter-input" placeholder="please input content">
                                    </div>
                                </div>
                                <div class="dropmenu-items">
                                    <div class="dropmenu-item">
                                        <span class="item-icon"><span class="octicon octicon-plus"></span></span>
        <span class="item-content">
            <div class="item-lable">添加</div>
        </span>
                                    </div>
                                    <div class="dropmenu-item">
                                        <span class="item-icon octicon octicon-pencil"></span>
        <span class="item-content">
            <div class="item-lable">编辑</div>
        </span>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                    <!-- /btn-group -->

                </form>
            </div>

            <div id="showlink">
                <ul>
                    <li>
                        <div class="showlinkicon"><a target="_blank" href="http://www.solidot.org/?theme=clightgreen">
                            <img width="16px" height="16px" style="margin-right:5px;"
                                 src="http://www.solidot.org/favicon.ico">奇客
                            </img>
                        </a>
                            <span class="linkedit linkediticon octicon octicon-pencil"></span>
                            <span class="linkedit linkdelicon octicon octicon-x"></span></div>
                    </li>
                    <li>
                        <div class="showlinkicon"><a target="_blank" href="http://www.baidu.com">
                            <img width="16px" height="16px" style="margin-right:5px;"
                                 src="http://www.solidot.org/favicon.ico">百度
                            </img>
                        </a>
                            <span class="linkedit linkediticon octicon octicon-pencil"></span>
                            <span class="linkedit linkdelicon octicon octicon-x"></span></div>
                    </li>
                    <li>
                        <div class="showlinkicon"><a target="_blank" href="http://www.solidot.org/?theme=clightgreen">
                            <img width="16px" height="16px" style="margin-right:5px;"
                                 src="http://www.solidot.org/favicon.ico">奇客
                            </img>
                        </a>
                            <span class="linkedit linkediticon octicon octicon-pencil"></span>
                            <span class="linkedit linkdelicon octicon octicon-x"></span></div>
                    </li>
                    <li>
                        <div class="showlinkicon"><a target="_blank" href="http://www.solidot.org/?theme=clightgreen">
                            <img width="16px" height="16px" style="margin-right:5px;"
                                 src="http://www.solidot.org/favicon.ico">奇客
                            </img>
                        </a>
                            <span class="linkedit linkediticon octicon octicon-pencil"></span>
                            <span class="linkedit linkdelicon octicon octicon-x"></span></div>
                    </li>
                    <li>
                        <div class="showlinkicon"><a target="_blank" href="http://www.solidot.org/?theme=clightgreen">
                            <img width="16px" height="16px" style="margin-right:5px;"
                                 src="http://www.solidot.org/favicon.ico">奇客
                            </img>
                        </a>
                            <span class="linkedit linkediticon octicon octicon-pencil"></span>
                            <span class="linkedit linkdelicon octicon octicon-x"></span></div>
                    </li>
                    <li>
                        <div class="showlinkicon"><a target="_blank" href="http://www.solidot.org/?theme=clightgreen">
                            <img width="16px" height="16px" style="margin-right:5px;"
                                 src="http://www.solidot.org/favicon.ico">奇客
                            </img>
                        </a>
                            <span class="linkedit linkediticon octicon octicon-pencil"></span>
                            <span class="linkedit linkdelicon octicon octicon-x"></span></div>
                    </li>
                    <li>
                        <div class="showlinkicon"><a target="_blank" href="http://www.solidot.org/?theme=clightgreen">
                            <img width="16px" height="16px" style="margin-right:5px;"
                                 src="http://www.solidot.org/favicon.ico">奇客
                            </img>
                        </a>
                            <span class="linkedit linkediticon octicon octicon-pencil"></span>
                            <span class="linkedit linkdelicon octicon octicon-x"></span></div>
                    </li>
                    <li>
                        <div class="showlinkicon"><a target="_blank" href="http://www.solidot.org/?theme=clightgreen">
                            <img width="16px" height="16px" style="margin-right:5px;"
                                 src="http://www.solidot.org/favicon.ico">奇客
                            </img>
                        </a>
                            <span class="linkedit linkediticon octicon octicon-pencil"></span>
                            <span class="linkedit linkdelicon octicon octicon-x"></span></div>
                    </li>

                </ul>
                <div class="editlinkdlg">
                    <form>
                        <div class="form-group">
                            <label for="linkeditname">名称</label>
                            <input type="text" class="form-control" id="linkeditname">
                        </div>
                        <div class="form-group form-group-sm">
                            <label for="linkediturl">URL</label>
                            <input type="text" class="form-control" id="linkediturl">
                        </div>
                        <button type="button" class="btn btn-success">确定</button>
                        <button type="button" class="btn btn-danger" onclick="canceleditLink()">取消</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
</body>
<script charset="gbk" src="http://www.baidu.com/js/opensug.js"></script>
</html>