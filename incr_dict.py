def incr_dict(dct, iter):
	curr_dct = dct
	count = 0
	for i in iter:
		if type(curr_dct) is int:
			raise Exception("Input is improperly formatted")
		if count == len(iter) - 1:
			if i in curr_dct:
				#if this key is in the dictionary, increment it
				#print i, " is incremented"
				curr_dct[i] += 1
			else:
				#if this key isn't in the dictionary, initialize it
				#print i, " is initialized"
				curr_dct[i] = 1
			continue	
		if i in curr_dct:
			#if this dictionary exists, follow it down
			#print i, " is in dct"
			curr_dct = curr_dct[i]
		else:
			#if this dictionary does not exist, create it and follow it down
			#print i, " is not in dct"
			curr_dct[i] = {}
			curr_dct = curr_dct[i]
		count += 1
