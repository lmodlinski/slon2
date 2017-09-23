package com.psychogra.slon2.models;

import java.util.List;

/**
 * Created by lmodlinski on 23/09/2017.
 */

abstract public class Rule
{
	public abstract boolean isFullfilled(List<GameObject> model, List<GameObject> progress);
}
