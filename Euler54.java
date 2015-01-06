import java.util.Arrays;
import java.util.HashMap;

class Euler54 {
	
	public static void main(String[] args) {
		
		String pokerHands = "8CTSKC9H4S7D2S5D3SAC5CAD5DAC9C7C5H8DTDKS3H7H6SKCJSQHTDJC2D8STH8H5CQSTC9H4DJCKSJS7C5HKCQHJDASKH4CAD4S5HKS9C7D9H8D3S5D5CAH6H4H5C3H2H3SQH5S6SASTD8C4H7CTCKC4C3H7SKS7C9C6DKD3H4CQSQCACKHJC6S5H2H2DKD9D7CASJSADQHTH9D8HTS6D3SASAC2H4S5C5STCKCJD6CTS3CQDAS6HJS2C3D9HKC4H8SKD8S9S7C2S3S6D6S4HKC3C8C2D7D4D9S4SQH4HJD8CKC7STC2DTS8HQDAC5C3DKHQD6C6SADAS8H2HQS6S8D4C8S6CQHTC6D7D9D2S8D8C4CTS9S9D9CAC3D3CQS2S4HJH3D2DTD8S9H5HQS8S6D3C8CJDAS7H7D6HTD9DASJH6CQC9SKDJCAH8SQS4DTHACTS3C3D5C5S4DJS3D8H6CTS3SAD8C6D7C5D5H3S5CJC2H5S3D5H6H2SKS3D5DJD7HJS8HKH4HASJSQSQCTC6D7CKS3DQSTS2HJS4DAS9SJCKDQD5H4D5DKH7H3DJSKD4H2C9H6H5C9D6CJC2DTH9S7D6DASQDJH4DJS7CQS5C3HKHQDAD8C8H3STH9D5SAH9S4D9D8S4HJS3CTC8D2CKS5HQD3STS9HAHAD8S5C7H5DKD9H4D3D2DKSADKSKC9S6D2CQH9D9HTSTC9C6H5DQH4DAD6DQCJSKH9S3H9DJD5C4D9HASTCQH2C6DJC9C3CAD9SKH9D7DKC9C7CJCJSKD3HAS3C7DQDKHQS2C3S8S8H9H9CJCQH8D3CKC4C4H6DAD9H9D3SKSQS7HKH7D5H5DJDAD2H2C6HTHTC7D8D4H8CAS4S2HACQC3S6DTH4D4CKH4DTCKSAS7C3C6D2D9H6C8CTD5DQS2C7H4C9C3H9H5HJHTS7STD6HADQD8H8S5SAD9C8C7C8D5H9D8S2S4HKHKS9S2SKC5SAD4S7DQS9CQD6HJS5DAC8D2SASKHACJC3S9D9S3C9C5SJSAD3C3DKS3S5C9C8CTS4SJH8D5D6HKDQSQD3D6CKC8SJD6C3S8CTCQC3CQHJSKCJC8H2S9H9CJH8S8C9S8S2HQH4DQC9DKCASTH3C8S6HTH7C2H6S3C3HAS7SQH5SJS4H5HTS8HAHACJC9D8H2S4STCJC3C7H3H5C3DAD3C3S4CQCAS5DTH8C6S9D4CJSKHAHTSJD8HAD4C6S9D7SAC4D3D3STCJDAD7H6H4HJHKCTDTS7D6S8HJHTC3S8D8C9S2C5C4D2C9DKCQHTHQSJC9C4HTSQS3CQD8HKH4H8DTD8SAC7C3CTH5S8H8C9CJDTCKDQCTCJDTS8C3H6HKD7CTDJHQSKS9C6D6SAS9HKH6H2H4DAH2DJH6HTD5D4HJDKD8C9SJHQDJS2CQS5C7C4STC7H8D2S6H7S9C7CKC8C5D7H4STDQC8SJS4HKSAD8SJH6DTDKD7C6C2D7DJC6H6SJS4HQH9HAH4C3C6H5HAS7C7S3DKHKC5D5CJC3DTDAS4D6D6SQHJDKS8C7S8SQH2SJD5C7HAHQD8S3C6H6C2C8DTD7D4C4D5DQHKH7C2S7HJS6DQCQDAD6C6S7DTH6H2H8HKH4HKSJSKD5D2DKH7D9C8C3D9C6DQD3CKS3S7SAHJD2DAHQHASJC8S8H4CKCTH7DJC5HTD7C5DKD4CAD8HJSKC2HACAH7DJHKH5D7S6D9S5S9C6H8STDJD9H6CAC7D8S6DTSKD7HAC5S7C5DAHQCJC4CTC8C2HTS2C7DKDKC6S3D7D2S8S3H5S5C8S5D8H4C6HKC3H7C5SKDJH8C3D3C6CKCTD7H7C4CJCKC6HTSQSTDKS8H8C9S6C5S9CQH7DAHKSKC9S2C4D4S8HTD9C3S7D9DASTH6S7D3C6H5DKD2C5C9D9C2HKC3DAD3HQDQS8DJC4S8C3H9C7CAD5DJC9DJSAS5D9H5C7H6S6CQCJCQD9SJCQSJH2C6S9CQC3D4STC4H5S8D3D4D2SKC2HJS2CTD3STHKD4D7HJHJSKSAC7S8C9S2D8S7D5CAD9DAS8C7H2S6CTH3H4C3S8HACKD5HJC8HJD2D4HTDJH5C3DASQHKS7HJD8S5S6D5H9S6STCQSJC5C5D9CTH8C5H3SJH9H2S2C6S7SASKS8CQDJCQSTCQC4HACKH6CTC5H7DJH4H2H8DJCKS4D5S9CKHKD9H5CTS3D7D2D5HASTC4D8C2CTS9D3H8D6H8D2D9HJD6C4S5H5S6DAD9CJC7D6H9S6DJS9H3CADJHTCQS4C5D9S7C9CAHKD6H2HTH8SQDKS9D9HAS4H8H8D5H6CAH5SASAD8SQS5D4S2HTDKS5HAC3HJC9C7DQDKDAC6D5HQH6H5SKCAHQH2H7DQS3HKS7SJD6C8S3H6DKSQD5D5C8HTC9H4D4S6S9DKHQC4H6CJDTD2DQH4S6HJHKD3CQD8C4S6H7CQD9DASAH6SAD3C2CKCTH6H8DAH5C6D8S5DTDTS7CADJCQD9H3CKC7H5D4D5S8H4H7D3HJDKD2DJHTD6HQS4SKD5C8S7D8HAC3DAS8CTD7HKH5D6CJD9DKS7C6DQHTCJDKDASKCJH8S5S7S7DAS2D3DAD2H2H5DAS3CQDKC6H9H9S2C9D5DTH4CJH3H8DTC8H9H6HKD2CTD2H6C9D2DJS8CKD7S3C7CASQHTSAD8C2SQS8H6CJS4C9SQCADTDTS2H7CTSTC8C3C9H2D6DJCTC2H8DJHKS6D3HTDTH8H9DTD9HQC5D6C8H8CKCTS2H8C3DAH4DTHTC7D8HKCTS5C2D8C6SKHAH5H6HKC5S5DAHTC4CJD8D6H8C6CKCQD3D8H2DJC9H4HAD2STD6S7DJSKD4HQS2S3S8C4C9HJHTS3S4HQC5S9S9C2CKD9HJS9S3HJCTS5DACAS2H5DAD5HJC7STDJS4C2D4S8H3D7D2CADKD9CTS7HQDJH5HJSAC3DTH4C8H6DKHKCQD5CAD7C2D4HAC3D9DTC8SQD2CJC4HJDAH6CTD5STC8SAH2C5DASACTH7S3DAS6C4C7H7D4HAH5C2HKS6H7S4H5H3D3C7H3C9SAC7SQH2H3D6S3S3H2D3HAS2C6HTCJS6S9C6CQHKDQD6DAC6HKH2CTS8C8H7D3S9H5D3H4SQC9S5H2D9D7H6H3C8S5H4D3S4SKD9S4STC7SQC3S8S2H7HTC3D8C3H6C2H6HKSKD4DKC3D9S3HJS4S8H2D6C8S6HQS6CTCQD9H7D7C5H4DTD9D8D6S6CTC5DTSJS8H4HKCJD9HTC2C6S5H8HASJS9C5C6S9DJD8HKC4C6D4D8D8S6C7C6H7H8H5CKCTC3DJC6DKS9S6H7S9C2C6C3SKD5HTS7D9H9S6HKH3DQD4C6HTSAC3S5C2HKD4CASJS9S7CTS7H9HJCKS4H8CJD3H6HAD9S4S5SKS4C2C7D3DAS9C2SQSKC6C8S5H3D2SAC9D6S3S4DTDQDTH7STS3DAC7H6C5DQCTCQDAD9CQS5C8DKD3D3C9D8HAS3S7C8SJD2D8DKC4CTHACQHJS8D7D7S9CKH9D8D4CJH2C2SQDKDTS4H4D6D5D2DJH3S8S3HTCKHAD4D2CQS8CKDJHJDAH5C5C6C5H2HJH4HKS7CTC3H3C4CQC5DJH9CQDKH8DTC3H9CJS7HQHAS7C9H5HJC2D5SQD4S3CKC6S6C5C4C5DKH2DTS8S9CAS9S7C4C7CAH8C8D5SKDQHQSJH2C8C9DAH2HACQC5S8H7H2CQD9H5SQSQC9C5HJCTH4H6C6S3H5H3S6HKS8DAC7SACQH7H8C4SKC6C3D3STC9D3DJSTHAC5H3H8S3STCQDKHJSKS9SQC8DAH3CAC5H6CKH3S9SJH2DQDAS8C6C4D7S7H5SJC6S9H4HJHAH5S6H9SAD3STH2H9D8C4C8D9H7CQCAD4S9CKC5S9D6H4DTC4CJH2S5D3SAS2H6C7CKH5CADQSTHJD8S3S4S7SAHASKCJS2SADTHJSKC2S7D8C5C9CTS5H9D7S9S4DTDJHJSKH6H5D2CJDJSJCTH2D3DQD8CAC5H7SKH5S9D5DTD4S6H3C2D4S5DAC8D4D7CADASAH9C6STHTSKS2CQCAHAS3C4S2H8C3SJC5C7C3H3CKHJH7S3HJC5S6H4C2S4DKC7H4D7C4H9S8S6SADTC6CJCKHQS3STC4C8H8SAC3CTSQDQSTH3CTS7H7DAHTDJCTDJDQC4D9S7STSAD7DACAH7H4S6D7C2H9DKSJCTD7CAHJD4H6DQSTS2H2C5CTCKC8C9S4CJS3CJC6SAHAS7DQC3D5SJCJD9DTDKHTH3C2S6HAHAC5H5C7S8HQC2DACQD2S3SJDQS6S8HKC4H3C9DJS6H3S8SAS8C7HKC7DJD2HJCQH5S3HQS9HTD3S8H7SAC5C6CAH7C8D9HAHJDTDQS7D3S9C8SAHQH3CJDKC4S5S5DTDKS9H7H6SJHTH4C7CAD5C2D7CKD5STC9D6S6C5D2STHKC9H8D5H7H4HQC3D7CAS6S8SQCTD4S5CTHQSQD2S8S5HTHQC9H6SKC7D7C5C7HKDAH4DKH5C4S2DKCQH6S2CTDJCAS4D6C8C4H5SJCTCJD5S6S8DAS9DAD3S6D6H5D5STC3D7DQS9DQD4S6C8S3S7SADKS2D7D7CKCQHJCACQD5D8DQS7H7DJSAH8S5H3DTD3H4S6CJH4SQS7DAS9HJSKS6DTC5C2D5C6HTC4DQH3D9H8S6C6D7HTCTH5SJD5C9CKSKD8DTDQH6S4S6C8SKC5CTC5S3DKSAC4S7DQD4CTH2STS8H9S6S7SQH3CAH7H8C4C8CTSJSQC3D7D5D7SJH8S7S9DQCAC7C6D2HJHKCJSKD3C6S4S7CAHQCKS5HKS6S4HJDQSTC8HKC6HASKH7CTC6STDJC5C7DAH3S3H4C4HTCTH6S7H6D9CQH7D5H4S8CJS4D3D8SQHKC3H6SAD7H3SQC8S4S7SJS3SJDKHTH6HQS9C6C2DQD4SQH4D5HKC7D6D8DTH5STDAD6S7HKDKH9H5SKCJC3HQCASTS4SQDKS9C7SKCTS6SQC6CTHTC9D5C5DKDJS3S4HKD4CQD6D9SJC9D8SJS6D4HJH6H6S6CKSKHAC7D5DTC9SKH6SQD6HASAS7H6DQH8DTH2SKH5C5H4C7C3DQCTC4SKH8C2DJS6H5D7S5H9C9HJH8STH7HASJS2SQDKH8H4SAC8D8S3H4CTDKD8CJC5CQS2DJDTS7D5D6C2CQS2H3CAHKS4S7C9C7DJH6C5C8H9DQD2STD7S6D9C9SQSKHQH5CJC6S9CQHJH8D7SJSKH2H8D5HTHKC4D4S3S6S3DQS2DJD4CTD7C6DTH7SJCAHQS7S4CTH9DTSAD4D3H6H2D3H7DJD3DAS2S9CQC8S4H9H9C2C7SJHKD5C5D6HTC9H8HJC3C9S8DKSADKCTS5HJDQSQHQC8D5DKHAH5DAS8S6S4CAHQCQDTH7H3H4H7D6S4S9HAS8HJS9DJD8C2C9D7D5H5S9SJCKDKD9C4SQDAH7CAD9DACTD6S4H4S9C8DKSTC9DJH7C5SJC5H4SQHAC2CJS2S9S8C5HASQDAD5C7D8SQCTDJC4C8D5CKHQS4D6H2H2CTH4S2DKC3HQDAC7HAD9DKHQDAS8HTHKC8D7SQH8CJC6C7D8CKHADQS2H6S2DJCKH2D7DJSQC5H4C5DADTS3SAD4STD2DTH6S9HJH9H2DQS2C4S3DKHASAC9DKH6S8H4SKD7D9DTSQDQCJH5HAHKSASADJCQC5SKH5D7D6DKSKD3D7C4DJD3SACJS8D5H9C3H4H4DTS2C6HKSKH9D7C2S6S8S2H3D6HACJS7S3STD8H3H4HTH9HTCQCKC5CKS6H4HAC8STC7DQH4SJCTS6D6CACKHQH7D7CJHQSQDTH3H5DKS3D5S8DJS4C2CKS7H9C4H5H8S4HTD2C3SQDQC3HKCQCJSKD9CAD5S9D7D7HTS8CJCKH7C7S6CTS2CQDTH5S9DTH3C7SQH8S9C2H5H5D9H6H2SJSKH3H7C2H5SJD5D5S2CTC2S6S6C3C8S4DKH8H4H2DKS3H5C2S9H3S2DTD7H8S6HJDKC9C8D6SQDJH7C9H5H8S8HTHTDQS7STD7DTSJCKD7C3C2C3CJD8S4H2D2STDAS4DACAHKS6C4C4S7D8C9H6HAS5S3C9S2CQSKD4D4SAC5D2DTS2CJSKHQH5D8CASKCKD3H6CTH8S7SKH6H9SAC6H7S6CQSAH2S2H4H5D5H5HJCQD2C2SJDASQC6S7D6CTCASKD8H9D2C7DJH9S2H4C6CAH8STD3HTH7CTSKD4STS6CQH8D9D9CAH7D6DJS5CQDQC9C5D8C2HKD3CQHJHAD6SAHKC8S6D6H3D7C4C7S5S3S6S5HJC3CQH7C5H3C3S8CTS4CKD9CQD3S7S5H7HQHJC7C8CKD3CKDKH2S4CTSAC6S2C7C2CKH3C4C6H4D5H5S7SQD4D7C8SQDTS9DKS6HKD3CQS4DTS7S4C3HQD8D9STCTSQHAC6S3C9H9DQS8S6H3S7S5D4SJS2D6CQH6STH4C4HASJS5D3DTS9CAC8S6S9C7C3S5CQSADAS6H3C9S8C7H3H6S7CAS9HJDKH3D3H7S4D6C7CAC2H9CTH4H5S3HACTCTH9C9H9S8D8D9H5H4D6C2HQD6S5D3S4C5CJDQS4D3HTHACQH8CQC5S3C7HAD4CKS4HJD6DQSAH3HKS9H2SJSJH5H2H2H5STH6STS3SKS3C5HJS2D9S7H3DKCJH6D7DJSTDACJS8H2C8CJHJC2DTH7S5D9S8H2H3DTCAHJCKD9C9DQDJC2H6DKHTS9SQHTH2C8D4SJD5H3HTHTC9CKCAS3D9H7D4DTHKH2H7S3H4H7SKS2SJSTS8S2HQD8D5S6HJHKS8H2SQCAC6S3SJCASADQS8H6CKH4C4DQD2S3DTSTD9SKS6SQS5C8D3C6D4SQCKCJHQDTHKHAD9HAH4DKS2S8DJHJC7CQS2D6CTH3C8HQDQH2S3SKS6H5D9S4CTSTDJSQD9DJD5H8HKH8SKS7CTDAD4SKD2C7CJC5SAS6C7D8S5H9C6SQD9STSKHQS5SQH3CKC7D3H3CKD5CASJH7H6HJD9D5C9HKC8HKS4SAD4D2S3SJDQD8D2S7C5S6S5HTS6D9SKCTD3S6HQDJD5C8D5H9DTSKD8D6HTDQC4C7D6D4SJD9DAH9SASTD9HQD2D5S2H9C6H9STDQC7DTC3S2HKSTS2C9C8SJS9D7D3CKC6D5D6C6H8SAS7SQSJH9S2H8D4C8H9HADTHKHQCAS2SJS5C6HKD3H7H2CQD8H2S8D3S6DAH2CTC5CJDJSTS8S3H5DTDKCJC6H6SQSTC3H5DAHJC7C7D4H7C5D8H9C2H9HJHKH5S2C9C7H6STH3SQCQD4CACJD2H5D9S7DKC3SQS2DASKH2S4S2H7D5CTDTHQH9S4D6D3STS6H4HKS9D8H5S2D9HKS4H3S5C5DKH6H6SJSKCAS8C4CJCKHQCTHQDAH6SKH9S2C5HTC3C7HJC4DJD4S6S5S8D7H7S4D4C2H7H9H5DKH9C7CTSTC7S5H4C8DQCTS4S9H3DADJS7C8CQS5C5D3HJSAHKC4S9DTSJD8SQSTHJHKH2DQDJSJDQC5D6S9H3S2C8H9STS2S4CAD7HJC5C2D6D4H3D7SJS2C4H8CADQD9C3STDJDTS4C6H9H7DQD6D3CASAS7C4C6S5D5S5CJSQC4SKD6S9S7C3C5S7DJHQDJS4S7SJH2C8S5D7H3DQHADTD6H2H8D4H2D7CADKH5DTS3S5H2CQDAH2S5CKHTDKC4D8C5DAS6C2H2S9H7CKDJSQCTSQSKHJH2C5DAD3S5HKC6C9H3H2HAD7D7S7SJSJHKD8S7D2S9H7C2H9H2D8DQC6SADAS8H5H6C2S7H6C6D7D8C5D9DJC3C7C9C7HJD2HKD3SKHAD4SQHAS9H4DJDKSKDTSKH5H4C8H5S3S3D7DTDAD7SKCJS8S5SJC8HTH9C4D5DKC7C5S9CQD2CQHJS5H8DKHTD2SKS3DADKC7STC3C5D4C2SADQS6C9SQDTHQH5C8CADQS2D2SKCJDKS6CJC8D4DJS2H5DQD7S7DQHTS6S7H3S8C8S9DQS8H6C9S4STC2S5CQD4DQS6DTH6S3S5C9D6H8D4C7DTC7CTDAH6SAS7H5SKD3H5HAC4C8D8SAHKSQS2CAD6H7D5D6H9H9S2HQS8S9C5D2DKDTSQC5SJH7D7STH9S9HAC7H3H6SKC4D6D5C4SQDTSTD2S7CQD3HJH9D4H7S7HKS3D4H5HTC2SAS2D6D7D8H3C7HTD3HADKCTH9CKHTC4C2C9S9D9C5C2HJD3C3HACTS5DAD8D6HQC6S8C2STS3SJD7H8SQH4C5S8DAC4S6C3CKH3D7C2D8S2H4H6C8STH2H4S8H9S3H7S7C4C9C2C5CAS5DKD4DQH9H4HTSAS7D8D5D9S8C2HQCKDACAD2H7SAS3S2D9S2HQC8HTC6DQDQS5DKH3CTHJDQS4C2S5SAD7H3SAS7HJS3D6C3S6DAS9SACQS9CTSAS8CTC8S6H9D8D6C4DJD9CKC7C6DKS3S8CAS3H6STC8DTS3SKC9S7CAS8CQC4H4S8S6C3STCAHAC4D7D5CAS2H6STSQCADTCQDQC8S4STH3DAHTSJH4H5C2D9S2C3H3C9DQDQH7DKC9H6CKD7S3C4DASTC2D3DJS4D9DKS7DTHQC3H3C8D5S2H9D3H8C4C4H3CTHJCTH4S6SJD2D4D6C3D4CTS3S2D4HAC2C6S2HJH6HTD8SADTCAHACJH9S6S7S6CKC4SJD8D9H5S7HQHAHKD8DTSJH5C5H3HADASJS2D4H3D6C8C7SAD5D5C8STD5D7S9C4S5H6C8C4C8SJSQH9CAS5CQSJC3DQC7CJC9CKHJHQSQC2CTS3DAD5DJHAC5C9STS4CJD8CKSKCAS2DKH9H2C5S4D3D6HTHAH2D8SJC3D8CQH7S3S8HQD4HJCASKHKS3C9S6D9SQH7D9C4SAC7HKH4DKDAHADTH6D9C9SKDKSQH4HQD6H9C7CQS6D6S9D5SJHAH8D5HQD2HJCKS4HKH5S5C2SJS8D9C8C3DASKCAHJD9S2HQS8H5S8CTH5C4CQCQS8C2S2C3S9C4CKSKH2D5D8SAHADTD2CJSKS8CTC5S5H8HQC9H6HJD4H9S3CJH4H9HAH4S2H4C8DAC8STH4D7D6DQDQS7STC7CKH6D2DJD5HJSQDJH4H4S9C7SJH4S3STSQC8CTC4HQH9D4DJHQS3S2C7C6C2D4H9SJD5C5HAH9DTS2D4CKSJHTS5D2DAHJS7HAS8DJSAH8CADKS5S8H2C6CTH2H5DADACKS3D8HTS6HQC6D4HTS9C5HJSJH6SJD4CJHQH4H2C6D3C5D4CQSKC6H4H6C7H6S2S8SKHQC8C3H3D5DKS4HTDAD3S4DTS5S7C8S7D2CKS7S6C8CJS5D2H3S7C5CQD5H6D9C9HJS2SKD9S8DTDTSAC8C9D5HQD2SAC8C9HKS7C4S3CKHAS3H8S9CJSQS4SAD4DAS2STDAD4D9HJC4C5HQS5D7C4HTC2D6CJS4SKC3S4C2C5DAC9H3DJD8SQSQH2C8S6H3CQH6DTCKDACAHQC6C3SQS4SAC8D5CADKH5S4CACKHASQC2C5C8D9C8HJD3CKH8D5C9CQDQH9D7HTS2C8C4STDJC9C5HQHJS4S2C7CTH6CASKS7SJDJH7C9H7HTC5H3D6D5D4D2CQDJH2H9D5S3DTDADKSJDQH3S4DTH7D6SQSKS4HTCKS5S8D8HAD2S2D4CJH5SJHTC3S2DQS9D4CKD9SACKH3HAS9DKC9HQD6C6S9H7S3D5C7DKCTD8H4H6S3C7H8HTCQD4D7S6SQH6C6DAD4CQD6C5D7D9DKSTSJH2HJD9S7STSKH8D5D8H2D9S4C7D9D5HQD6DAC6S7S6DJCQDJH4C6SQS2H7D8CTDJHKD2H5CQS2CJS7STC5H4HJHQD3S5S5D8SKHKSKH7C2C5DJH6S9C6DJC5HAHJD9CJSKC2H6H4D5SAS3CTHQC6H9C8S8CTD7CKC2CQD9CKH4D7S3CTS9H9CQC2STS8CTD9SQD3S3C4D9DTHJHAH6S2SJDQHJSQD9H6CKD7D7H5D6S8HAH8H3C4S2H5HQSQH7S4HACQS3C7S9S4H3SAHKS9D7CAD5S6S2H2D5HTC4S3C8CQHTS6S4DJSKSJHAS8S6D2C8S2STD5HASTCTS6CKCKCTS8H2H3H7C4C5STHTDKDADKH7H7S5D5H5S2D9CAD9S3D7S8CQC7C9CKDKS3CQC9S8C4D5CASQD6C2C2HKC8SJD7SAC8D5C2S4D9DQH3D2STC3SKS3C9HTDKD6SAC2C7H5H3S6C6H8CQHTC8S6SKHTH4H5DTS4D8CJS4H6H2C2H7DACQD3DQSKC6S2D5S4HTD3HJH4C7S5H7H8HKH6HQSTHKD7D5HADKD7CKH5STD6D3C6C8C9C5HJD7CKCKH7H2H3S7S4HAD4D8SQSTH3D7H5S8DTCKSKD9S6DADJD5C2S7H8H6CQD2H6H9DTC9S7C8D6D4C7C6C3CTHKHJSJH5S3S8SJS9HASAD8H7SKDJH7C2CKC5HASAD9C9SJSADAC2C6SQD7C3HTHKSKD9DJD4H8H4CKH7STS8CKC3S5S2H7S6H7DKS5C6DAD5S8C9HQS7H7S2H6C7DTDQS5STDAC9DKC3DTC2D4DTD2H7DJDQD4C7H5DKC3D4C3H8SKDQH5SQC9HTC5H9CQDTH5HTS5C9HAHQH2C4D6S3CAC6C3D2C2HTDTHAC9C5DQC4DAD8D6D8CKCAD3C4HAC8D8H7S9STDJC4H9HQHJS2DTHTDTCKDKS5S6S9S8DTHASKH5H5C8SJD2S9S6S5S8S5D7S7H9D5D8C4C9DADTS2C7DKDTC8SQS4DKC5C8D4SKHJDKDAS5CADQH7D2H9S7H7CTC2S8SJDKH7S6C6DAD5DQC9H6H3S8C8HAHTC4HJSTD2CTS4D7H2DQC9C5DTH7C6C8HQC5DTSJH5C5H9H4S2DQC7HASJS8S2H4C4H8DJS6SACKD3D3C4S7HTHKCQHKH6SQS5S4H3CQD3S3H7HASKH8C4H9C5S3D6STS9C7C3H5SQD2C3DADAC5HJHTD2D4CTS3HKHAD3S7SAS4C5H4D6SKDJC3C6H2D3H6S8C2DTH4SAHQHAD5H7C2S9H7HKC5C6D5S3HJC3CTC9C4HQDTDJH6D9H5S7C6S5C5D6C4S7H9H6HAHAD2H7DKC2C4C2S9S7H3STH4C8S6S3SADKSASJHTD5CTD4S4DAD6S5DTC9C7D8H3S4D4S5S6H5CAC3H3D9H3CAC4SQS8S9DQH5H4DJC6C5HTSAC9CJD8C7CQD8S8H9CJD2DQCQH6H3C8DKSJS2H6H5HQHQS3H7C6DTC3H4S7HQC2H3S8CJSKHAH8H5S4C9HJD3H7SJCAC3C2D4C5S6C4SQS3SJD3D5H2DTCAHKS6D7HAD8C6H6C7S3CJD7C8HKSKHAH6DAH7D3H8H8S7HQS5H9D2DJDAC4H7S8S9SKSAS9DQH7S2C8S5SJHQSJCAHKD4CAH2S9H4H8DTSTD6HQHJD4HJC3HQS6D7S9C8S9D8D5HTD4S9S4C8C8D7H3H3DQSKH3S2C2S3C7STD4SQD7CTD4D5SKHACAS7H4C6C2S5H6DJD9HQS8S2C2HTD2STS6H9H7S4HJC4C5D5S2C5H7D4H3SQHJCJS6D8H4CQH7CQD3SADTH8S5STS9HTC2STDJC7D3S3DTHQH7D4C8S5CJH8H6S3SKC3HJC3HKHTCQHTH6H2CAC5HQS2H9D2CAS6S6C2S8C8S9H7DQCTH4HKDQSAC7S3C4DJH6S5S8HKS9SQC3SASJD2D6S7STC9HKC3H7DKD2HKH7C4D4S3HJSQD7DKC4CJCAS9D3CJS6C8HQD4DAHJS3S6C4C3DJH6D9C9H9H2D8C7H5SKS6H9C2STC6C8CAD7H6H3DKHAS5DTHKS8C3STS8S4D5S9S6C4H9H4S4H5C7DKC2D2H9DJH5CJSTC9D9H5H7SKHJC6S7C9H8H4DJCKHJD2HTDTC8H6C2H2CKH6H9DQSQH5HAC7D2S3DQDJC2D8DJDJH2HJC2D7H2C3C8DKDTD4H3S4H6D8DTS3HTD3D6HTHJHJC3SACQH9H7H8SQC2C7HTDQS4S8S9C2S5D4D2H3DTS3H2SQC8H6HKCJCKS5DJD7DTC8C6C9S3D8DAC8H6HJH6C5D8D8S4HAD2C9D4H2D2C3STSASTC3C5D4DTH5HKSQS6C4S2H3DAD5CKC6H2C5S3C4D2D9H9SJD4C3HTHQH9H5SAH8SAC7D9S6S2HTD9C4H8HQS4C3C6H5D4H8C9CKC6SQDQS3S9HKDTC2DJS8C6S4H4S2S4C8SQS6HKH3HTH8C5D2CKH5S3S7S7H6C9DQD8D8HKSAC2DKHTS6CJSKC7H9CKS5CTDQCAH6C5H9S7C5D4D3H4H6S7C7SAHQDTD2H7DQC6STCTSAH7S9D3HTH5HQD9SKS7S7C6H8CTDTH2D4DQC5C7DJDAH9C4H4H3HAH8D6HQCQH9H2H2C2DAD4CTS6H7STH4HQSTD3CKD2H3HQSJDTCQC5D8HKSJCQDTH9SKD8D8C2D9C3CQDKD6D4D8DAHADQC8S8H3S9D2S3HKS6H4C7CKCTH9S5C3D7D6HAC7S4D2C5C3DJD4D2D6D5H9H4CKHAS7HTD6C2H3DQDKS4C4SJC3CAC7CJDJS8H9SQC5DJD6S5S2HAS8C7D5HJH3D8DTC5S9S8S3HJC5H7SAS5CTD3D7D4H8D7H4D5DJSQS9CKSTD2S8S5C2H4HASTH7S4H7D3HJDKD5D2SKCJD7H4S8H4CJS6HQH5S4H2CQS8C5S3HQC2S6CQDAD8C3DJDTC4H2HAD5SAC2S5D2CJS2DAD9D3D4C4SJH8D5H5D6H7S4DKS9DTDJD3D6D9C2SAS7D5S5C8HJD7C8S3S6S5HJDTCAD7H7S2S9DTS4DAC8D6CQDJD3H9SKH2C3CAC3D5H6H8D5DKS3D2D6SAS4C2S7C7HKHAC2H3SJC5CQH4D2D5H7STSASJD8C6HJC8S5S2C5D7SQH7H6CQC8H2D7CJD2S2CQD2S2HJC9C5D2DJDJH7C5C9C8S7D6D8D6C9SJH2CAD6S5H3SKS7S9DKH4C7H6C2C5CTH9D8D3SQCAH5SKC6HTC5H8STH6D3CAH9CKD4HADTD9S4S7D6H5D7H5C5H6DAS4CKDKH4H9D3C2S5C6CJDQS2H9D7D3HAC2S6S7SJSQD5CQS6HAD5HTHQC7HTC3S7C6DKC3D4H3DQC9S8H2C3SJCKS5C4S6S2C6H8S3S3D9H3HJS4S8C4D2D8H9H7D9DAHTS9S2C9H4C8DAS7D3D6D5S6S4C7H8C3H5HJCAH9D9C2S7C5SJD8C3S3D4D7D6S3CKC4S5D7D3DJD7H3H4H9C9H4H4DTH6DQD8S9S7S2HAC8S4SAD8C2CAH7DTCTS9H3CADKSTC3D8C8HJDQC8D2C3C7D7CJD9H9C6CAH6SJSJH5DASQC2CJDTD9HKD2H5D2D3S7DTCAHTSTD8HAS5DAHQCAC6STC5HKS4S7H4D8D9CTC2H6H3H3HKD4SQDQH3D8H8CTD7S8SJDTCAHJSQS2DKHKS4D3CADJCKDJSKH4STH9H2CQC5SJS9SKSAS7CQD2SJDKC5SQS3S2DAC5D9H8HKS6H9CTCAD2C6D5SJD6C7CQSKHTDQD2C3H8S2SQCAH9D9HJHTCQH3C2SJS5C7H6C3S3D2S4SQD2DTH5D2C2D6H6D2SJCQHAS7H4HKH5H6SKSADTCTS7CAC4S4HAD3C4HQS8C9DKS2H2D4D4S9D6C6D9CAC8D3H7HKDJCAH6CTSJD6DAD3S5DQDJCJHJD3S7S8SJSQC3H4SJDTH5C2CADJS7H9S2H7S8D3SJH4DQCASJD2CKC6H2CAC5HKD5S7HQDJHAH2DJCQH8D8STC5H5CAH8C6C3HJS8SQDJH3C4H6D5C3S6D4S4CAH5H5S3HJD7C8D8HAH2H3HJS3C7DQC4HKD6S2HKD5H8H2D3C8S7SQD2S7SKCQCAHTCQS6D4C8D5S9H2C3SQD7S6C2H7C9D3C6C5C5SJDJCKS3S5DTS7CKS6S5S2S2DTC2H5HQSAS7H6STS5H9S9D3CKD2H4SJSQS3S4H7C2SAC6S9D8CJH2H5H7C5DQHQSKHQC3STD3H7CKC8D5H8SKH8C4HKHJDTS3C7HASQCJS5SAH9D2C8D4D2D6H6CKC6S2S6H9D3S7H4DKH8HKD3D9CTCACJHKH4DJD5HTD3S7S4H9DAS4C7DQS9S2SKH3S8D8SKS8CJC5CKH2H5D8SQH2C4DKCJSQC9DAC6H8S8C7CJSJD6S4C9CAC4SQH5D2C7DJC8S2DJSJH4CJS4C7STSJHKCKH5HQD4SQD8C8D2D6STD9DACQH5SQHQCJS3D3C5C4HKH8S7H7C2C5SJC8S3HQC5D2HKC5S8DKD6H4HQDQH6DAH3D7SKS6C2S4DACQS5HTSJD7C2DTC5DQSACJSQC6CKC2CKS4D3HTS8SAD4H7S9SQD9HQH5H4H4DKH3SJCAD4DACKC8D6D4C2DKH2CJD2C9H2DAH3H6D9C7DTCKS8C3HKD7C5C2S4S5HASAHTHJD4HKD3HTC5C3SACKH6D7HAH7SQC6H2DTDJDASJH5D7HTC9S7DJCAS5SKH2H8CADTH6HQDKD9H6S6CQHKC9D4D3SJSJH4H2C9HTC7HKH4HJC7D9S3HQS7SAD7DJH6C7H4H3S3H4DQHJD2H5CAS6CQC4D3CTCJHACJD3H6H4CJCAD7D7H9H4HTCTS2C8C6SKS2HJD9S4C3HQSQC9S9H6DKC9D9C5CAD8C2CQHTHQDJC8D8HQC2C2SQD9C4D3S8DJHQS9D3S2C7S7CJCTD3CTC9H3CTS8H5C4C2C6S8D7C4HKS7H2HTC4H2C3SASAHQS8C2D2H2C4S4C6S7D5S3STHQC5DTD3CQSKDKCKSAS4DAHKD9HKS5C4C6HJC7SKC4H5CQSTC2HJC9SAHQH4S9H3H5H3CQD2HQCJH8H5DAS7H2C3DJH6H4C6S7D9CJD9HAHJS8SQH3HKS8H3SACQCTS4DAD3DAH8S9H7H3HQS9C9S5HJHJSAHAC8D3CJD2HAC9C7H5S4D8H7CJH9H6CJS9S7H8C9D4H2DAS9S6H4DJSJH9HADQD6H7SJHKHAH7HTD5S6S2C8HJH6S5H5S9DTC4CQC9S7D2CKD3H5HASQD7HJS4DTSQH6C8HTH5H3C3H9C9DADKHJS5D3HASAC9S5CKC2CKH8CJCQS6DAH2DKCTC9D3H2S7C4D6DKHKS8D7D9H2STCJHACQC3H5S3S8H3SASKD8H4C3H7CJHQHTS7S6D7H9DJH4C3D3S6CAS4S2H2C4C8S5HKC8CQCQD3H3S6CQSQC2D6S5D2C9D2H8DJH2S3H2D6C5C7SAD9HJS5DQH8STS2H7S6SAD6DQC9S7H5H5C7DKCJD4HQC5S9H9C4D6SKS2S4C7C9H7C4H8D3S6H5C8HJS7S2D6HJSTD4H4DJCTH5HKCAC7C8DTH3H9S2D4CKC4DKDQS9C7S3DKSADTS4C4HQH9C8H2S7DKS7H5DKD4C9C2S2HJC6S6CTCQCJH5C7SAC8HKC8S6HQSJC3D6SJS2DJH8C4S6H8H6D5DAD6H7D2S4H9H7CASAC8H5S3CJS4S6D5H2SQH6S9C2C3D5S6S9S4CQS8DQD8STC9C3DAH9H5S2C7DADJC3S7HTCAS3C6S6D7SKHKC9H3STC8H6S5HJH8C7DAC2SQD9D9C3SJC8CKS8H5D4DJSAHJD6D9D8C9H9S8H3H2D6S4C4D8SAD4STCAH9HTSACQCTHKC6D4H7S8C2H3CQDJS9D5SJCAH2HTS9H3H4DQH5D9C5H7D4SJC3S8STH3H7C2HJDJSTSAC8D9C2HTDKCJD2S8C5SAD2C3DKD7C5H4DQHQDTC6H7D7H2CKC5SKD6HAHQC7SQH6H5CAC5H2C9C2D7CTD2S4D9DAH3D7CJD4H8C4CKSTH3CJSQH8H4CAS3DQSQC4D7S5HJH6D7D6HJSKH3CQD8S7D2H2C7CJC2S5H8CQH8S9DTC2HAD7C8DQD6S3S7CAD9H2H9SJDTS4C2D3SAS4HQC2C8H8S7STDTCJHTHTD3S4D4H5S5DQS2C8CQDQHTC6D4S9S9D4HQC8CJS9D6HJD3HAD6STDQCKC8S3D7CTD7D8D9H4S3S6C4S3D9DKDTCKCKSAC5S7C6SQH3DJSKD6H6D2D8CJD2S5S4H8SAC2D6STS5C5H8C5S3C4S3D7C8DAS3HASTS7C3HAD7DJCQS6C6H3S9S4CACQH5H5D9HTS4H6C5C7H7STDADJD5S2H2S7D6CKC3SJD8D8STSQSKH8SQS8D6CTHACAH2C8H9S7HTDKHQH8S3D4DAHJDASTS3D2HJC2SJHKH6CQCJSKCTH2D6H7S2STC8C9DQS3C9D6SKH8H6D5DTH2C2H6HTC7DAD4D8STS9HTD7SJS6DJDJC2HAC6C3DKH8DKHJD9S5D4H4C3H7SQS5C4HJD5D3S3C4DKHQHQS7SJDTS8SQDAH4C6H3S5S2CQS3DJDAS8DTH7C6SQCKS7S2H8CQC7HAC6D2DTHKH5S6C7HKH7DAH8C5C7S3D3CKDAD7D6C4DKS2D8C4S7C8D5S2D2SAHAD2C9DTD3CAD4SKSJH7C5C8C9CTHASTD4D7CJD8CQH3C5H9S3H9C8S9S6SQDKSAH5HJHQC9C5S4H2HTD7DAS8C9D8C2C9DKDTC7S3DKHQC3C4DAS4CQS5S9D6SJDQHKS6DAH6C4C5HTS9H7D3D5SQSJD7C8D9CAC3S6S6CKH8HJH5D9S6DAS6S3SQC7HQDAD5CJH2HAH4HASKC2CJH9C2C6H2DJS5D9HKC6D7D9DKDTH3HAS6SQC6HADJD4H7DKC3HJS3CTH3DQS4C3H8CQD5H6HAS8HADJDTH8SKD5DQC7DJS5S5HTS7DKC9DQS3H3C6DTS7SAH7C4H7HAHQCAC4D5D6DTH3C4H2SKD8H5HJHTC6CJD4S8C3D4HJSTD7SJHQSKD7CQCKD4D7H6SADTDTCKH5H9HKC3H4D3DAD6SQD6HTH7C6HTSQH5S2CKCTD6S7C4D5SJDJH7DACKDKH4H7D6C8D8H5CJH8SQDTHJD8D7D6C7C9DKDAS5CQHJH9S2C8C3C4CKSJH2D8D4H7S6CJHKH8H3H9D2DAH6D4DTC9C8D7HTDKSTHKD3CJD9H8DQDASKD9D2C2S9C8D3H5C7HKS5HQH2D8C9H2DTH6DQD6CKC3H3SAD4C4H3HJS9D3CTC5HQHQCJC3D5C6H3S3CJC5S7S2SQHAC5C8C4D5D4H2SQD3C3H2CTDAH9CKDJS6SQD4CQCQS8C3S4HTCJS3H7CJCAD5H4D9CKSJCTD9STS8S9HQDTS7DASAC2CTD6H8HAH6SAD8C4S9H8D9DKH8S3CQS4D2D7SKHJSJCAD4C3CQS9S7HKCTDTH5HJSACJH6DAC2SQS7CASKS6SKH5S6D8HKH3CQS2H5C9C9D6CJS2C4C6H7DJCACQDTD3H4HQC8HJD4CKDKS5CKC7S6D2D3H2SQD5S7HASTH6SAS6D8D2C8STD8HQDJCAH9C9H2DTDQH2H5CTC3D8HKC8S3DKH2STSTC6S4DJH9H9DQSACKC6H5D4D8DAH9S5CQS4H7C7D2H8SADJS3DAC9SAS2C2D2H3HJCKH7HQHKHJDTCKS5S8H4C8D2H7H3S2S5HQS3CAS9HKDAD3DJD6H5S9C6DAC9S3S3D5D9C2DAC4S2SAD6C6SQC4C2D3H6SKCQHQD2HJHQC3C8S4D9S2H5C8HQSQD6DKD6S7H3SKH2H5CJC6C3S9STC6S8H2DAD7S8STS3C6H9C3H5CJC8HQHTDQD3CJSQD5DTD2CKH9HTHAS9STCJD3D5C5HADQH9HKCTC7H4H8H3HTD6SAC7C2SQS9D5D3CJCKS4D6CJH2S9S6S3C7HTS4CKD6D3D9C2D9HAHAC7H2SJH3S7CQCQD9H3C2HACAS8SKD8CKH2D7STDTH6DJD8D4D2H5S8SQHKDJDQSJH4DKC5H3S3CKHQC6D8H3SAH7DTD2D5S9HQH4S6S6C6DTSTH7S6C4C6DQSJS9CTS3H8D8SJS5C7SAS2CAH2HAD5STCKD6C9C9DTS2SJC4H2CQDQS9HTC3HKCKS4H3CADTHKH9C2HKD9DTC7SKCJH2D7C3SKCAS8C5D9C9SQH3H2D8CTD4C2HQC5DTC2C7DKS4D6CQHTDKH5D7CAD8D2S9S8S4C8C3D6HQD7C7H6C8SQH5HTS5C3C4S2S2H8S6S2HJC3S3H9D8C2S7HQC2C8H9CACJD4C4H6S3S3H3S7D4C9S5H8HJC3DTCQH2S2D9SKDQD9HAD6D9C8D2DKS9SJC4CJDKC4STHKHTS6D4D5CKD5HAS9HADQDJS7C6D5D5CTH5HQHQS9DQHKH5HJH4C4DTCTH6CKHASTS9DKD9C7S4D8H5SKHAS2S7D9D4CTSTHAH7CKS4DAC8S9S8DTHQH9D5C5D5C8CQSTC4C3D3S2C8D9DKS2D3CKC4S8CKH6CJC8HAH6H7D7SQD3C4C6CKC3H2CQH8HAS7D4C8C4HKCQD5S4H2CTDAHJHQH4C8S3HQS5SJS8H2S9H9C3S2C6HTS7SJCQDACTDKC5S3HQHASQS7DJCKC2C4C5C5SQH3DASJS4H8D7HJC2S9C5D4D2S4S9D9C2DQS8H7H6D7H3HJSTSAC2DJH7C8SJH5HKC3CTC5S9H4C8H9D8SKC5H9HADKS9DKH8DAHJC2H9HKS6S3HQC5HAH9C5CKH5SAD6CJC9HQC9CTD5S5DJCQH2DKS8HQS2HTSJH5H5SAH7H3C8SASTDKH6H3DJD2C4CKC7SAH6CJH4CKS9DAD7SKC7D8H3S9C7H5C5H3C8HQC3DKH6DJC2D4H5D7DQCADAH9HQH8HKD8CJS9D3S3C2H5D6D2S8S6STS3C6H8D5S3HTD6CKS3DJH9C7C9SQS5S4H6H7S6STH4SKCKD3SJCJHKS7C3C2S6DQH2C7S5H8HAHKC8DQD6DKH5C7H9D3D9C6H2D8SJS9S2S6DKC7CTCKD9CJH7HKC8S2S7S3D6H4H9H2D4C8H7H5S8S2H8DAD7C3C7S5S4D9H3DJCKH5DAS7D6D9CJC4CQHQSKHKDJD7D3DQSQC8S6DJSQD6S8C5SQHTH9HASAC2CJDQCKSQH7S3C4C5CKC5DAH6C4H9DAH2C3HKD3DTS5CTD8SQSASJS3HKDAC4HKS7D5DTS9H4H4C9C2H8CQC2C7D9H4DKS4CQHADKDJSQDADAHKH9DJS9HJCKDJD8S3C4STS7S4D5C2S6H7CJS7S5CKD6DQH8STD2H6SQH6CTC6HTD4C9D2HQC8H3DTS4D2H6H6S2C7H8S6C9H9DJDJH3SAH2C6S3H8S2CQS8C5S3H2S7D3CAD4S5CQCQHASTS4S6S4C5HJSJH5CTD4C6HJSKDKHQS4HTCKHJC4D9H9D8DKC3C8H2HTC8SAD9S4HTS7H2C5C4H2S6C5SKSAH9C7C8HKDTSQHTDQS3CJHAH2C8D7D5DKC3H5SAC4S7HQS4C2H3D7DQCKHJH6D6CTDTHKD5S8DTH6C9D7DKH8C9S6DJDQS7SQC2SQHJC4SKS8D7S5S9SJDKD9CJCAD2D7C4S5HAHJH9C5DTD7C2D6SKC6C7H6S9CQD5S4HKSTD6S8DKS2DTHTD9HJDTS3SKHJS4H5D9DTCTDQCJDTSQSQDACAD4C6S2DAS3HKC4C7C3CTDQS9CKCAS8DADKC7HQC6D8H6S5SAH7S8C3SAD9HJC6DJDASKH6SJHAD3DTSKS7HJH2DJSQDAC9CJD7C6DTC6H6CJC3D3SQCKC3SJCKD2C8DAHQSTSASKD3DJD8H7C8C5CQD6C";
		
		long start = System.currentTimeMillis();
		int handOneWins = 0;
		for(int x = 0; x + 19 < pokerHands.length(); x += 20) {
			PokerHand handOne = new PokerHand(pokerHands.substring(x, x + 10));
			PokerHand handTwo = new PokerHand(pokerHands.substring(x + 10, x + 20));
			if(handOne.rank > handTwo.rank) {
				handOneWins++;
			}
			else if(handOne.rank == handTwo.rank){
				if(handOne.highestWinner.value > handTwo.highestWinner.value) {
					handOneWins++;
				}
				else if(handOne.highestWinner.value == handTwo.highestWinner.value) {
					if(handOne.winsTieBreak(handTwo)) {
						handOneWins++;
					}
				}
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("One Wins: " + handOneWins);
		System.out.println("Time: " + (end - start) + " ms");
	}
}

class PokerCard implements Comparable<PokerCard> {
	
	public short value; // 1 - 14
	public char suit; // 'C', 'D', 'H', 'S'
	
	private static HashMap<Character, Short> values = new HashMap<Character,Short>();
	static {
		values.put('1', (short)1);
		values.put('2', (short)2);
		values.put('3', (short)3);
		values.put('4', (short)4);
		values.put('5', (short)5);
		values.put('6', (short)6);
		values.put('7', (short)7);
		values.put('8', (short)8);
		values.put('9', (short)9);
		values.put('T', (short)10);
		values.put('J', (short)11);
		values.put('Q', (short)12);
		values.put('K', (short)13);
		values.put('A', (short)14);
	}
	
	public PokerCard(char value, char suit) {
		this.value = values.get(value);
		this.suit = suit;
	}
	
	public int compareTo(PokerCard other) {
		return this.value - other.value;
	}
}

class PokerHand {
	
	public short rank;
	public PokerCard[] cards;
	public PokerCard highestWinner;
	
	public PokerHand(String hand) {
		cards = new PokerCard[5];
		char[] h = hand.toCharArray();
		for(int i = 0; i < 5; i++)
			cards[i] = new PokerCard(h[i*2],h[i*2+1]);
		Arrays.sort(cards);
		highestWinner = cards[4];
		rank = calculateRank();
	}
	
	public boolean winsTieBreak(PokerHand other) {
		for(int i = cards.length-1; i >= 0; i--) {
			if(this.cards[i].value < other.cards[i].value)
				return false;
			if(this.cards[i].value > other.cards[i].value)
				return true;
		}
		System.out.println("Should never get here");
		return true;
	}
	
	private short calculateRank() {
		if(isFlush()) {
			if(isStraight()) {
				if(cards[0].value == 10) 
					return 10; // Royal Flush
				return 9; // Straight Flush
			}
		}
		if(hasSet(4)) return 8; // 4-kind
		if(isFullHouse()) return 7; // Full House
		if(isFlush()) return 6; // Flush
		if(isStraight()) return 5; // Straight
		if(hasSet(3)) return 4; // 3-kind
		if(hasTwoPair()) return 3; // 2 Pair
		if(hasSet(2)) return 2; // 1 Pair
		return 1; // High Card
	}
	
	private boolean isFullHouse() {
		if(cards[0].value == cards[1].value && cards[1].value == cards[2].value && cards[3].value == cards[4].value) {
			highestWinner = cards[0];
			return true;
		}
		if(cards[0].value == cards[1].value && cards[2].value == cards[3].value && cards[3].value == cards[4].value) {
			return true;
		}
		return false;
	}
	
	private boolean hasTwoPair() {
		if(cards[1].value == cards[2].value && cards[3].value == cards[4].value) {
			return true;
		}
		if(cards[0].value == cards[1].value && cards[3].value == cards[4].value) {
			return true;
		}
		if(cards[0].value == cards[1].value && cards[2].value == cards[3].value) {
			highestWinner = cards[3];
			return true;
		}
		return false;
	}
	
	private boolean hasSet(int tuple) {
		for(int i = 0; i < cards.length-(tuple-1); i++) {
			boolean hasSet = true;
			for(int j = 1; j < tuple; j++) {
				hasSet = hasSet && (cards[i].value == cards[i+j].value);
				if(!hasSet) break;
			}
			if(!hasSet) continue;
			highestWinner = cards[i];
			return true;
		}
		return false;
	}
	
	private boolean isFlush() {
		for(int i = 0; i < cards.length-1; i++)
			if(cards[i].suit != cards[i+1].suit)
				return false;
		return true;
	}
	
	private boolean isStraight() {
		for(int i = 0; i < cards.length-1; i++)
			if (cards[i].value + 1 != cards[i+1].value)
				return false;
		return true;
	}
}