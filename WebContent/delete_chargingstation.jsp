<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import="java.sql.*" %>
    <%@ page import="com.chargingstation.DbConnection" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Responsive Admin &amp; Dashboard Template based on Bootstrap 5">
    <meta name="author" content="AdminKit">
    <meta name="keywords"
        content="adminkit, bootstrap, bootstrap 5, admin, dashboard, template, responsive, css, sass, html, theme, front-end, ui kit, web">

    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link rel="shortcut icon" href="img/icons/icon-48x48.png" />

    <link rel="canonical" href="https://demo-basic.adminkit.io/ui-forms.html" />

    <title>View Own CND Request |EV charging station Management</title>

    <link href="css/app.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;600&display=swap" rel="stylesheet">
</head>

<body>
    <div class="wrapper">
       <nav id="sidebar" class="sidebar js-sidebar">
			<div class="sidebar-content js-simplebar">
				<a class="sidebar-brand" href="index.html">
					<span class="align-middle">ev charging station</span>
				</a>

				<ul class="sidebar-nav">
					<li class="sidebar-header">
						User
					</li>

					

					<li class="sidebar-item active">
						<a class="sidebar-link" href="addForm.html">
							<i class="align-middle" data-feather="user"></i> <span class="align-middle">addForm</span>
						</a>
					</li>

					<li class="sidebar-item">
						<a class="sidebar-link" href="chargingstation_view.jsp">
							<i class="align-middle" data-feather="log-in"></i> <span class="align-middle">View table</span>
						</a>
					</li>

					

				</ul>
				=

				
			</div>
		</nav>

        <div class="main">
            <nav class="navbar navbar-expand navbar-light navbar-bg">
                <a class="sidebar-toggle js-sidebar-toggle">
                    <i class="hamburger align-self-center"></i>
                </a>

                <div class="navbar-collapse collapse">
                    <ul class="navbar-nav navbar-align">

                        <li class="nav-item dropdown">
                            <a class="nav-icon dropdown-toggle d-inline-block d-sm-none" href="#"
                                data-bs-toggle="dropdown">
                                <i class="align-middle" data-feather="settings"></i>
                            </a>

                            <a class="nav-link dropdown-toggle d-none d-sm-inline-block" href="#"
                                data-bs-toggle="dropdown">
                                <img src="img/avatars/avatar.png" class="avatar img-fluid rounded me-1"
                                    alt="Charles Hall" /> <span class="text-dark">Riddhi Magare</span>
                            </a>
                            <div class="dropdown-menu dropdown-menu-end">
                                <a class="dropdown-item" href="pages-profile.html"><i class="align-middle me-1"
                                        data-feather="user"></i> Profile</a>
                                <a class="dropdown-item" href="#"><i class="align-middle me-1"
                                        data-feather="pie-chart"></i> Analytics</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="index.html"><i class="align-middle me-1"
                                        data-feather="settings"></i> Settings & Privacy</a>
                                <a class="dropdown-item" href="#"><i class="align-middle me-1"
                                        data-feather="help-circle"></i> Help Center</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="index.html">Log out</a>
                            </div>
                        </li>
                    </ul>
                </div>
            </nav>

            <main class="content">

                <div class="container-fluid p-0">

                    <div class="mb-3">
                        <h1 class="h3 d-inline align-middle">View Own CND Request</h1>

                    </div>

                    <div class="row">
                        <div class="col-md-12">
                            <div class="card">

                              		 <% 
  Connection con=DbConnection.connect(); 
try{
	PreparedStatement pstmt=con.prepareStatement("select * from chargingstation");
	ResultSet rs=pstmt.executeQuery();
%>  
<table class="table table-hover my-0">
									<thead>
										<tr>
								
										
											
											<th class="d-none d-xl-table-cell">cid</th>
											<th class="d-none d-xl-table-cell">station_name</th>
											<th class="d-none d-xl-table-cell">address</th>
											<th class="d-none d-xl-table-cell">city</th>
											<th class="d-none d-xl-table-cell">taluka</th>
											<th class="d-none d-xl-table-cell">district</th>
											<th class="d-none d-xl-table-cell">opentime</th>
											<th class="d-none d-xl-table-cell">closetime</th>
											<th class="d-none d-xl-table-cell">mobileno</th>
											<th class="d-none d-xl-table-cell">lattitude</th>
											<th class="d-none d-xl-table-cell">longitude</th>
											<th class="d-none d-xl-table-cell">power</th>
											<th class="d-none d-xl-table-cell">password</th>
											<th class="d-none d-xl-table-cell">status</th>
											<th class="d-none d-xl-table-cell">delete record</th>
											
										</tr>
										<% while(rs.next()){ 
											%>
									</thead>
									<tbody>
									
								
										<tr>
										<td class="d-none d-xl-table-cell"><%=rs.getInt(1)%></td>
										<td class="d-none d-xl-table-cell"><%=rs.getString(2)%></td>
										<td class="d-none d-xl-table-cell"><%=rs.getString(3)%></td>
										<td class="d-none d-xl-table-cell"><%=rs.getString(4)%></td>
										<td class="d-none d-xl-table-cell"><%=rs.getString(5)%></td>
										<td class="d-none d-xl-table-cell"><%=rs.getString(6)%></td>
                                        <td class="d-none d-xl-table-cell"><%=rs.getString(7)%></td>
                                        <td class="d-none d-xl-table-cell"><%=rs.getString(8)%></td>
                                        <td class="d-none d-xl-table-cell"><%=rs.getInt(9)%></td>
                                        <td class="d-none d-xl-table-cell"><%=rs.getString(10)%></td>
                                        <td class="d-none d-xl-table-cell"><%=rs.getString(11)%></td>
                                        <td class="d-none d-xl-table-cell"><%=rs.getString(12)%></td>
                                        <td class="d-none d-xl-table-cell"><%=rs.getString(13)%></td>
                                        <td class="d-none d-xl-table-cell"><%=rs.getString(14)%></td>
                                        <td class="d-none d-xl-table-cell"> <a href="delete.jsp?cid=<%=rs.getInt(1)%>">delete</a></td>
										
									 </tr>
										<% }
}catch(Exception e){
	
	e.printStackTrace();
	}%>

										
									</tbody>

  
								</table>

                            </div>
                        </div>
                    </div>

                </div>

            </main>

            <footer class="footer">
                <div class="container-fluid">
                    <div class="row text-muted">
                        <div class="col-6 text-start">
                            <p class="mb-0">
                                <a class="text-muted" href="https://adminkit.io/" target="_blank"><strong>Waste
                                        Management</strong></a> &copy;
                            </p>
                        </div>
                        <div class="col-6 text-end">
                            <ul class="list-inline">
                                <li class="list-inline-item">
                                    <a class="text-muted" href="https://adminkit.io/" target="_blank">Support</a>
                                </li>
                                <li class="list-inline-item">
                                    <a class="text-muted" href="https://adminkit.io/" target="_blank">Help Center</a>
                                </li>
                                <li class="list-inline-item">
                                    <a class="text-muted" href="https://adminkit.io/" target="_blank">Privacy</a>
                                </li>
                                <li class="list-inline-item">
                                    <a class="text-muted" href="https://adminkit.io/" target="_blank">Terms</a>
                                </li>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="index.html">Log out</a>
                            </div>
                            </ul>
                        </div>
                    </div>
                </div>
            </footer>
        </div>
    </div>

    <script src="js/app.js"></script>

</body>

</html>