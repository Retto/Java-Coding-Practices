package com.retto.practices04;

class Solution {

	private void reflectForces(char[] array, int[] forces, int index, int force) 
	{
		if(index < 0 || index >= forces.length)
			return;
		if(array[index] == '.') {
			forces[index] += force;
		}
	}
		
	private int changeDominoesStatus(char[] array, int[] forces) {
		int changed = 0;
		for(int i=0; i < forces.length; i++) {
			if(forces[i] > 0) {
				array[i] = 'R';
				changed++;
			} else if(forces[i] < 0) {
				array[i] = 'L';
				changed++;
			}
		}
		
		return changed;
	}
	
	public String pushDominoes(String dominoes) {
		char[] array = dominoes.toCharArray();

		int[] forces = new int[array.length];
		

		for (int i = 0; i < array.length; i++) {
			char current = array[i];
			switch (current) {
			case '.':
				break;
			case 'R':
				reflectForces(array, forces, i+1, +1);
				break;
			case 'L':
				reflectForces(array, forces, i-1, -1);
				break;
			default:
				break;
			}
		}
		
		int changed = changeDominoesStatus(array, forces);
		
		// check termination control
		if(changed == 0) {
			return new String(array);
		} else {
			// next iteration for all dominoes 
			return pushDominoes(new String(array));
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();

		System.out.println(s.pushDominoes("...RL....R.L.L........RR......L....R.L.....R.L..RL....R....R......R.......................LR.R..L.R."));
		// Expected Output: ...RL....R.LLL........RRRRRLLLL....R.L.....R.L..RL....RRRRRRRRRRRRRRRRRRRRRRRR.LLLLLLLLLLLLRRRRLL.RR 
	}
}
