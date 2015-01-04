from incr_dict import incr_dict

dct = {}
incr_dict(dct,('a','b','c'))
print dct
incr_dict(dct,('a','b','c'))
print dct
incr_dict(dct,('a','b','f'))
print dct
incr_dict(dct,('a','r','f'))
print dct
incr_dict(dct,('a','z'))
print dct
try:
	incr_dict(dct,('a','b','c','d'))
except:
	print "Exception raised"
print dct
incr_dict(dct,('b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'))
print dct
incr_dict(dct,('b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'))
print dct
incr_dict(dct,('b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','4','r','s','t','u','v','w','x','y','z'))
print dct
