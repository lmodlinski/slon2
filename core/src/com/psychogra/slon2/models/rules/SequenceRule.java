package com.psychogra.slon2.models.rules;

import java.util.List;

/**
 * Created by lmodlinski on 23/09/2017.
 */

public class SequenceRule extends Rule
{
	@Override
	public boolean isValid(List model, List progress)
	{
		if (model.size() >= progress.size()) {
			for (int i = 0, size = progress.size(); i < size; i++) {
				if (!progress.get(i).equals(model.get(i))) {
					return false;
				}
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
