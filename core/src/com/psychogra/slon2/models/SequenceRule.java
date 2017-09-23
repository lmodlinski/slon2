package com.psychogra.slon2.models;

import java.util.List;

/**
 * Created by lmodlinski on 23/09/2017.
 */

public class SequenceRule extends Rule
{
	@Override
	public boolean isFullfilled(List<GameObject> model, List<GameObject> progress)
	{
		if (model.size() == progress.size()) {
			for (int i = 0, size = model.size(); i < size; i++) {
				if (!model.get(i).equals(progress.get(i))) {
					return false;
				}
			}

			return true;
		}

		return false;
	}
}
