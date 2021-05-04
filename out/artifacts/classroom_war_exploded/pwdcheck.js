function validate() {
    var pw1 = document.getElementsByName("password").value;
    var pw2 = document.getElementsByName("password1").value;
    if(pw1 != pw2) {
        document.getElementById("tishi").innerHTML="<font color='red'>两次密码不同</font>";
        document.getElementById("submit").disabled = false;
    }

}