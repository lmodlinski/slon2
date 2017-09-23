package com.psychogra.slon2.models.rules;

import com.psychogra.slon2.models.GameObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lmodlinski on 23/09/2017.
 */

public class EqualityRule extends Rule
{
	@Override
	public boolean isFullfilled(List<GameObject> model, List<GameObject> progress)
	{
		if (model.size() == progress.size()) {
			List<GameObject> copy = new ArrayList<GameObject>(progress);
			int copy_index = -1;

			for (int i = 0, size = model.size(); i < size; i++) {
				if (-1 == (copy_index = copy.indexOf(model.get(i)))) {
					return false;
				}

				copy.remove(copy_index);
			}

			return true;
		}

		return false;
	}
}
