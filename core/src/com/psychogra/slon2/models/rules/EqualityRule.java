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
	public boolean isValid(List model, List progress)
	{
		if (model.size() >= progress.size()) {
			List<GameObject> copy = new ArrayList<GameObject>(model);
			int copy_index = -1;

			for (int i = 0, size = progress.size(); i < size; i++) {
				if (-1 == (copy_index = copy.indexOf(progress.get(i)))) {
					return false;
				}

				copy.remove(copy_index);
			}

			return true;
		}

		return false;
	}

	@Override
	public boolean isFulfilled(List model, List progress)
	{
		if (model.size() == progress.size()) {
			return this.isValid(model, progress);
		}

		return false;
	}
}
