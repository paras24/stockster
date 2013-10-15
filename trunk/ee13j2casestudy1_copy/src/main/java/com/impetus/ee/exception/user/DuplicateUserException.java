package com.impetus.ee.exception.user;

import com.impetus.ee.exception.TeamPlannerException;

public class DuplicateUserException extends TeamPlannerException
{
	public DuplicateUserException()
	{
		super("User already exists in the system.");
	}
}
