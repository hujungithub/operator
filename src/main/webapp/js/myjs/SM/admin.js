(function() {
function admin() = {

}
admin.prototype.meow = function() {
console.log('喵');
}
window.admin = admin;

//在cookie中获取参数c_name
function getCookie(c_name)
{
  if (document.cookie.length>0) {
    c_start = document.cookie.indexOf(c_name+"=");//返回位置
    console.log("c_start === "+c_start);
    if (c_start != -1) {
      c_start = c_start + c_name.length + 1;
      c_end = document.cookie.indexOf(";",c_start);
      console.log(c_start+"===="+c_end);
      if (c_end == -1) c_end = document.cookie.length;
      return unescape(document.cookie.substring(c_start,c_end));
    }
  }
  return "";
}
//在cookie中存储key-value键值对，保存期为expireDays
function setCookie(c_name,value,expiredays)
{
  var exdate = new Date();
  exdate.setDate(exdate.getDate() + expiredays);
  document.cookie=c_name+"="+escape(value)+((expiredays == null)?"":";expires="+exdate.toGMTString())
}

//检查cookie值
function checkCookie()
{
  username = prompt('Please enter your name :',"");
  if (usename != null && username != "")
  {
      alert("Welcome again"+username+"!");
  }
  else {
    username = prompt('Please enter your name:',"");
    if (username != null && username != "") {
      setCookie("username",username,365);
    }
  }
}


})()
