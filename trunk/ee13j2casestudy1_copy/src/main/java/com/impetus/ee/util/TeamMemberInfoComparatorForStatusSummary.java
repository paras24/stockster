package com.impetus.ee.util;

import java.util.Comparator;

import com.impetus.ee.vo.TeamMemberInfo;

public class TeamMemberInfoComparatorForStatusSummary implements Comparator<TeamMemberInfo> 
{
	@Override
	public int compare(TeamMemberInfo o1, TeamMemberInfo o2) 
	{
		int compareValue = 0;
		compareValue = o1.getStatus().compareTo(o2.getStatus());
		if(compareValue==0)
		{
			compareValue = o1.getProject().compareTo(o2.getProject());
		}
		if(compareValue==0)
		{
			compareValue = o1.getSubProject().compareTo(o2.getSubProject());
		}
		return compareValue;
	}
}
