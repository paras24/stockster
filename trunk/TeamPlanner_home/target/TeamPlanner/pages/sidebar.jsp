<%@ taglib prefix="s" uri="/struts-tags" %>
<s:url var="teamPlannerUserUrL"value="/user/welcome.action"></s:url>
<s:url var="teamUrL"value="/team/listAllTeamMember.action"></s:url>
<div class="span2" id="sidebar">
		<!--<div class="well well-small"><a href="product_summary.html" id="myCart">3 Items in your cart  <span class="badge badge-warning pull-right">$155.00</span></a></div>-->
		<ul class="nav nav-tabs nav-stacked" id="sideManu">
			<!--<li class="subMenu open"><a> ELECTRONICS [230]</a>
				<ul>
				<li><a class="active" href="products.html"><i class="icon-chevron-right"></i>Cameras (100) </a></li>
				<li><a href="products.html"><i class="icon-chevron-right"></i>Computers, Tablets & laptop (30)</a></li>
				<li><a href="products.html"><i class="icon-chevron-right"></i>Mobile Phone (80)</a></li>
				<li><a href="products.html"><i class="icon-chevron-right"></i>Sound & Vision (15)</a></li>
				</ul>
			</li>-->			
			<li><a href="#">Projects</a></li>
			<li><a href="${teamUrL}">Team</a></li>
			<li><a href="#">Joining Pipeline</a></li>
			<li><a href="#">New Opportunities</a></li>
			<li><a href="#">Reports</a></li>
			<li><a href="${teamPlannerUserUrL}">Team Planner Users</a></li>			
		</ul>
</div>