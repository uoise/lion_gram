toastr.options = {
    closeButton: true,
    debug: false,
    newestOnTop: true,
    progressBar: true,
    positionClass: "toast-top-right",
    preventDuplicates: false,
    onclick: null,
    showDuration: "300",
    hideDuration: "1000",
    timeOut: "5000",
    extendedTimeOut: "1000",
    showEasing: "swing",
    hideEasing: "linear",
    showMethod: "fadeIn",
    hideMethod: "fadeOut"
};

function parseMsg(msg) {
    // 타임리프 문법(파라미터, ? 뒤에 입력된 매개변수들)
    const params = /*[[ ${param} ]]*/ null;

    if (params.msg) {
        toastNotice(params.msg[0]);
    }

    if (params.errorMsg) {
        toastWarning(params.errorMsg[0]);
    }
}


function toastNotice(msg) {
    toastr["success"](msg, "알림");
}

function toastWarning(msg) {
    toastr["warning"](msg, "알림");
}
