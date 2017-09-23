package com.psychogra.slon2.models.rules;

import java.util.List;

/**
 * Created by lmodlinski on 23/09/2017.
 */

abstract public class Rule
{
	public abstract boolean isValid(List model, List progress);

	public abstract boolean isFulfilled(List model, List progress);
}
