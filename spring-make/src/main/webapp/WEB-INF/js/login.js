let userid =$('#userid');
let userpw=$('#userpw');
let btn =$('#btn');


/*유효성 검사 */
$(btn).on('click', function(e){
    e.preventDefault();
    if($(userid).val()==""){
        $(userid).next('label').addClass('warning');
        setTimeout(function(){
            $(userid).next('label').removeClass('warning');
        },1500);
    }else if($(userpw).val()==""){
        $(userpw).next('label').addClass('warning');
        setTimeout(function(){
            $(userpw).next('label').removeClass('warning');
        },1500)
    }

})



