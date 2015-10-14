$(function () {
    $('.linkedit').addClass('hide');
    $("[data-toggle='tooltip']").tooltip({html: true});
    $('#treeview').treeview(treeviewobj);
    //$("#showlink ul").dragsort({});
    $(".we-edit").hide();
    $("#shownav4").dropmenu({
        title: '请选择分类',
        display: 'selection',
        showFilter: false,
        width: '180px',
        position: 'right'
    });
    $("#shownav").dropmenu({
        title: 'please choose item',
        display: 'complex',
        width: '280px',
        showFilter: false,
        position: 'left'
    });
    $('#menu').metisMenu();
    addnavlink()
    editNav();
    editLink();
});
var defaultData = [
    {
        text: 'Java',
        href: '#parent1',
        tags: ['4'],
        nodes: [
            {
                text: 'Spring',
                href: '#child1',
                tags: ['2'],
                nodes: [
                    {
                        text: 'SpringMVC',
                        href: '#grandchild1',
                        tags: ['0']
                    },
                    {
                        text: 'Spring.Net',
                        href: '#grandchild2',
                        tags: ['0']
                    }
                ]
            },
            {
                text: 'Child 2',
                href: '#child2',
                tags: ['0']
            }
        ]
    },
    {
        text: 'Parent 2',
        href: '#parent2',
        tags: ['0']
    },
    {
        text: 'Parent 3',
        href: '#parent3',
        tags: ['0']
    },
    {
        text: 'Parent 4',
        href: '#parent4',
        tags: ['0']
    },
    {
        text: 'Parent 5',
        href: '#parent5',
        tags: ['0']
    }
    ,
    {
        text: 'Parent 4',
        href: '#parent4',
        tags: ['0']
    },
    {
        text: 'Parent 5',
        href: '#parent5',
        tags: ['0']
    }
    ,
    {
        text: 'Parent 4',
        href: '#parent4',
        tags: ['0']
    },
    {
        text: 'Parent 5',
        href: '#parent5',
        tags: ['0']
    }
    ,
    {
        text: 'Parent 4',
        href: '#parent4',
        tags: ['0']
    },
    {
        text: 'Parent 5',
        href: '#parent5',
        tags: ['0']
    }
    ,
    {
        text: 'Parent 4',
        href: '#parent4',
        tags: ['0']
    },
    {
        text: 'Parent 5',
        href: '#parent5',
        tags: ['0']
    }
    ,
    {
        text: 'Parent 4',
        href: '#parent4',
        tags: ['0']
    },
    {
        text: 'Parent 5',
        href: '#parent5',
        tags: ['0']
    }
];

//setInitialStates,setEditableState,toggleEditBtn,buildTree,template
var treeviewobj = {
    expandIcon: 'octicon octicon-triangle-right',
    collapseIcon: 'octicon octicon-triangle-down',
    highlightSelected: false,
    color: '#4183c4',
    data: defaultData,
    onNodeEdit: function (event, data) {
        var positon = $(this).parent().position();
        $("#naveditname").val($(this).parent().text());
        $('.editdlg').css({
            left: positon.left,
            top: positon.top
        }).addClass('show');
    },
    onNodeDelete: function (event, data) {

    }
};

function addnavlink() {
    $('#addnavlink').on('click', function () {
        //todo:
        alert('add')
    })
}

//编辑导航
function editNav() {
    $("#editnav").on('click', function (e) {
        $('#treeview').treeview('toggleEditBtn');
        if ($('.linkedit').hasClass('hide')) {
            $('.linkedit').removeClass('hide').addClass('show');
        }
        else {
            $('.linkedit').removeClass('show').addClass('hide');
        }

        canceledit();
        canceleditLink();
    });
}

//取消编辑
function canceledit() {
    $('.editdlg').removeClass('show');
}

function canceleditLink() {
    $('.editlinkdlg').removeClass('show');
}

/*编辑链接*/
function editLink() {
    $('.linkediticon').on('click', function (event, data) {
        var $positon = $(this).parent().position();
        $("#linkeditname").val($.trim($(this).parent().children('a').text()));
        $("#linkediturl").val($.trim($(this).parent().children('a').attr('href')));
        $('.editlinkdlg').css({
            left: $positon.left + 4,
            top: $positon.top + 4
        }).addClass('show');
    })
}