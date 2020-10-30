<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Grails"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>

    <asset:stylesheet src="application.css"/>

   <asset:stylesheet rel="stylesheet" href="vendors/mdi/css/materialdesignicons.min.css"/>
  <asset:stylesheet rel="stylesheet" href="vendors/base/vendor.bundle.base.css"/>
  <!-- endinject -->
  <!-- plugin css for this page -->
  <asset:stylesheet rel="stylesheet" href="vendors/datatables.net-bs4/dataTables.bootstrap4.css"/>
  <!-- End plugin css for this page -->
  <!-- inject:css -->
  <asset:stylesheet rel="stylesheet" href="css/style.css"/>
    <g:layoutHead/>

  <style>
 
    footer header{
      width:100% !important;
      /* height:100vh !important;*/
    }
    .container-fluid{
      height:75vh !important;
    }
    header{
      display: flex;
      flex-direction: row; 
      justify-content: space-between;
      padding:15px !important;
    }
    .user-panel{
      display: flex;
      flex-direction: row; 
      justify-content: space-between;
    }
    .user-connecty {
       display: flex;
      flex-direction: row; 
      justify-content: space-between;
      justify-content: end;
    }
  </style>
</head>

<body>
  <header>
      <a class="navbar-brand brand-logo" href="index.html"><asset:image src="images/logo.svg" alt="logo"/></a>
      <div class="user-panel">
        
        <div class="user-connecty">
            <p> Kiran Patel</p>
            <a href="#"><i class="fa fa-circle user-online"></i><span class="txtOnline"> Online</span></a>
        </div>
        <div class="pull-left image">
            <asset:image src="images/faces/face5.jpg" class="img-circle user-img-circle" alt="User Image" />
        </div>
    </div>
  </header>
    <div class="container-fluid ">
      <g:layoutBody/>
    </div>
  <footer class="footer">
    <div class="">
      <span class="text-muted text-center text-sm-left d-block d-sm-inline-block">Copyright © 2018 <a href="https://www.bootstrapdash.com/" target="_blank">Bootstrapdash</a>. All rights reserved.</span>
      <span class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center">Hand-crafted & made with <i class="mdi mdi-heart text-danger"></i></span>
    </div>
  </footer>

  <asset:javascript src="application.js"/>
 <!-- plugins:js -->
  <asset:javascript src="vendors/base/vendor.bundle.base.js"/>
  <!-- endinject -->
  <!-- Plugin js for this page-->
  <asset:javascript src="vendors/chart.js/Chart.min.js"/>
  <asset:javascript src="vendors/datatables.net/jquery.dataTables.js"/>
  <asset:javascript src="vendors/datatables.net-bs4/dataTables.bootstrap4.js"/>
  <!-- End plugin js for this page-->
  <!-- inject:js -->
  <asset:javascript src="js/off-canvas.js"/>
  <asset:javascript src="js/hoverable-collapse.js"/>
  <asset:javascript src="js/template.js"/>
  <!-- endinject -->
  <!-- Custom js for this page-->
  <asset:javascript src="js/dashboard.js"/>
  <asset:javascript src="js/data-table.js"/>
  <asset:javascript src="js/jquery.dataTables.js"/>
  <asset:javascript src="js/dataTables.bootstrap4.js"/>
  <!-- End custom js for this page-->

</body>
</html>
