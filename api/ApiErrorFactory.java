package api;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.json.simple.JSONObject;

import at.AT_Constants;
import at.AT_Error;
import core.transaction.Transaction;
import gui.transaction.OnDealClick;
import lang.Lang;
import utils.Corekeys;
import utils.NameUtils.NameResult;

public class ApiErrorFactory 
{
	//COMMON
	
	private static final int ERROR = Transaction.AT_ERROR + 100;
	public static final int ERROR_UNKNOWN = ERROR;
	public static final int ERROR_JSON = ERROR + 1;
	//public static final int Екфтыфсешщт = 2;
	//public static final int ERROR_NOT_YET_RELEASED = ERROR + 3;
	
	//VALIDATION
	//public static final int ERROR_INVALID_SIGNATURE = ERROR + 101;
	//public static final int ERROR_INVALID_ADDRESS = 102;
	public static final int ERROR_INVALID_SEED = 103;
	public static final int ERROR_INVALID_AMOUNT = Transaction.INVALID_AMOUNT;
	//public static final int ERROR_INVALID_FEE_POW = ERROR + 105;
	//public static final int ERROR_INVALID_SENDER = 106;
	//public static final int ERROR_INVALID_RECIPIENT = 107;
	//public static final int ERROR_INVALID_NAME_LENGTH = 108;
	//public static final int ERROR_INVALID_VALUE_LENGTH = 109;
	//public static final int ERROR_INVALID_NAME_OWNER = 110;
	//public static final int ERROR_INVALID_BUYER = 111;
	//public static final int ERROR_INVALID_PUBLIC_KEY = 112;
	//public static final int ERROR_INVALID_OPTIONS_LENGTH = 113;
	//public static final int ERROR_INVALID_OPTION_LENGTH = 114;
	//public static final int ERROR_INVALID_DATA = ERROR + 115;
	//public static final int ERROR_INVALID_DATA_LENGTH = 116;
	//public static final int ERROR_INVALID_UPDATE_VALUE = ERROR + 117;
	//public static final int ERROR_NAME_KEY_ALREADY_EXISTS = ERROR + 118;
	//public static final int ERROR_NAME_KEY_NOT_EXISTS = ERROR + 119;
	//public static final int ERROR_LAST_KEY_IS_DEFAULT_KEY_ERROR = ERROR + 120;
	//public static final int ERROR_FEE_LESS_REQUIRED = 121;
	
	public static final int ERROR_WALLET_NOT_IN_SYNC = ERROR + 122;
	public static final int ERROR_INVALID_NETWORK_ADDRESS = ERROR + 123;
	
	//WALLET
	public static final int ERROR_WALLET_NO_EXISTS = ERROR + 201;
	public static final int ERROR_WALLET_ADDRESS_NO_EXISTS = ERROR + 202;
	public static final int ERROR_WALLET_LOCKED = ERROR + 203;
	public static final int ERROR_WALLET_ALREADY_EXISTS = ERROR + 204;
	public static final int ERROR_WALLET_API_CALL_FORBIDDEN_BY_USER = ERROR + 205;
	
	//BLOCKS
	//public static final int ERROR_BLOCK_NO_EXISTS = ERROR + 301;
	
	//TRANSACTIONS
	//public static final int ERROR_TRANSACTION_NO_EXISTS = ERROR + 311;
	//public static final int ERROR_PUBLIC_KEY_NOT_FOUND = ERROR + 304;	
		
	//NAMING
	//public static final int ERROR_NAME_NO_EXISTS = 401;
	//public static final int ERROR_NAME_ALREADY_EXISTS = 402;
	//public static final int ERROR_NAME_ALREADY_FOR_SALE = 403;
	//public static final int ERROR_NAME_NOT_LOWER_CASE = 404;
	//public static final int ERROR_NAME_SALE_NO_EXISTS = 410;
	//public static final int ERROR_BUYER_ALREADY_OWNER = 411;
	
	//POLLS
	//public static final int ERROR_POLL_NO_EXISTS = 501;
	//public static final int ERROR_POLL_ALREADY_EXISTS = 502;
	//public static final int ERROR_DUPLICATE_OPTION = 503;
	//public static final int ERROR_POLL_OPTION_NO_EXISTS = 504;
	//public static final int ERROR_ALREADY_VOTED_FOR_THAT_OPTION = 505;
	
	//ASSET
	//public static final int ERROR_INVALID_ASSET_ID = 601;
	
	//NAME PAYMENTS
	//public static final int ERROR_NAME_NOT_REGISTERED = 701;
	//public static final int ERROR_NAME_FOR_SALE = 702;
	//public static final int ERROR_NAME_WITH_SPACE = 703;
	
	//ATs
	public static final int ERROR_INVALID_DESC_LENGTH = ERROR + 801;
	public static final int ERROR_EMPTY_CODE = ERROR + 802;
	//public static final int ERROR_DATA_SIZE = ERROR + 803;
	public static final int ERROR_NULL_PAGES = ERROR + 804;
	public static final int ERROR_INVALID_TYPE_LENGTH = ERROR + 805;
	public static final int ERROR_INVALID_TAGS_LENGTH = ERROR + 806;
	public static final int ERROR_INVALID_CREATION_BYTES = ERROR + 809;
	
	//BLOG/Namestorage
	public static final int ERROR_BODY_EMPTY = ERROR + 901;
	public static final int ERROR_BLOG_DISABLED = ERROR + 902;
	public static final int ERROR_NAME_NOT_OWNER = ERROR + 903;
	public static final int ERROR_TX_AMOUNT = ERROR + 904;
	public static final int ERROR_BLOG_ENTRY_NO_EXISTS = ERROR + 905;
	public static final int ERROR_BLOG_EMPTY = ERROR + 906;
	public static final int ERROR_POSTID_EMPTY = ERROR + 907;
	public static final int ERROR_POST_NOT_EXISTING = ERROR + 908;
	public static final int ERROR_COMMENTING_DISABLED = ERROR + 909;
	public static final int ERROR_COMMENT_NOT_EXISTING = ERROR + 910;
	public static final int ERROR_INVALID_COMMENT_OWNER = ERROR + 911;
	
	//Messages
	public static final int ERROR_MESSAGE_FORMAT_NOT_HEX = ERROR + 1001;
	//public static final int ERROR_MESSAGE_BLANK = 1002;
	public static final int ERROR_NO_PUBLIC_KEY = ERROR + 1003;
	//public static final int ERROR_MESSAGESIZE_EXCEEDED = 1004;

	
	public static int BATCH_TX_AMOUNT = 50;
	
	
	private static ApiErrorFactory  instance;
	
	public static ApiErrorFactory  getInstance()
	{
		if(instance == null)
		{
			instance = new ApiErrorFactory();
		}
		
		return instance;
	}
	
	private Map<Integer, String> errorMessages;
	
	public ApiErrorFactory()
	{
		this.errorMessages = new HashMap<Integer, String>();
		
		//COMMON
		this.errorMessages.put(ERROR_UNKNOWN, Lang.getInstance().translate("unknown error"));
		this.errorMessages.put(ERROR_JSON, Lang.getInstance().translate("failed to parse json message"));
		//this.errorMessages.put(ERROR_NO_BALANCE, Lang.getInstance().translate("not enough balance"));
		//this.errorMessages.put(ERROR_NOT_YET_RELEASED, Lang.getInstance().translate("that feature is not yet released"));
		
		//VALIDATION		
		//this.errorMessages.put(ERROR_INVALID_SIGNATURE, Lang.getInstance().translate("invalid signature"));
		//this.errorMessages.put(ERROR_INVALID_ADDRESS, Lang.getInstance().translate("invalid address"));
		this.errorMessages.put(ERROR_INVALID_SEED, Lang.getInstance().translate("invalid seed"));
		//this.errorMessages.put(ERROR_INVALID_AMOUNT, Lang.getInstance().translate("invalid amount"));
		//this.errorMessages.put(ERROR_INVALID_FEE_POW, Lang.getInstance().translate("invalid fee"));
		//this.errorMessages.put(ERROR_INVALID_SENDER, Lang.getInstance().translate("invalid sender"));
		//this.errorMessages.put(ERROR_INVALID_RECIPIENT, Lang.getInstance().translate("invalid recipient"));
		//this.errorMessages.put(ERROR_INVALID_NAME_LENGTH, Lang.getInstance().translate("invalid name length"));
		//this.errorMessages.put(ERROR_INVALID_VALUE_LENGTH, Lang.getInstance().translate("invalid value length"));
		//this.errorMessages.put(ERROR_INVALID_NAME_OWNER, Lang.getInstance().translate("invalid name owner"));
		//this.errorMessages.put(ERROR_INVALID_BUYER, Lang.getInstance().translate("invalid buyer"));
		//this.errorMessages.put(ERROR_INVALID_PUBLIC_KEY, Lang.getInstance().translate("invalid public key"));
		//this.errorMessages.put(ERROR_INVALID_OPTIONS_LENGTH, Lang.getInstance().translate("invalid options length"));
		//this.errorMessages.put(ERROR_INVALID_OPTION_LENGTH, Lang.getInstance().translate("invalid option length"));
		//this.errorMessages.put(ERROR_INVALID_DATA, Lang.getInstance().translate("invalid data"));
		//this.errorMessages.put(ERROR_INVALID_DATA_LENGTH, Lang.getInstance().translate("invalid data length"));
		//this.errorMessages.put(ERROR_INVALID_UPDATE_VALUE, Lang.getInstance().translate("invalid update value"));
		//this.errorMessages.put(ERROR_KEY_ALREADY_EXISTS, Lang.getInstance().translate("key already exists, edit is false"));
		//this.errorMessages.put(ERROR_KEY_NOT_EXISTS, Lang.getInstance().translate("the key does not exist"));
		//this.errorMessages.put(ERROR_LAST_KEY_IS_DEFAULT_KEY_ERROR, Lang.getInstance().translate(("you can't delete the key \"%key%\" if it is the only key")).replace("%key%", Corekeys.DEFAULT.toString()));
		//this.errorMessages.put(ERROR_FEE_LESS_REQUIRED, Lang.getInstance().translate("fee less required"));
		this.errorMessages.put(ERROR_WALLET_NOT_IN_SYNC, Lang.getInstance().translate("wallet needs to be synchronized"));
		this.errorMessages.put(ERROR_INVALID_NETWORK_ADDRESS, Lang.getInstance().translate("invalid network address"));
				
		//WALLET
		this.errorMessages.put(ERROR_WALLET_NO_EXISTS, Lang.getInstance().translate("wallet does not exist"));
		this.errorMessages.put(ERROR_WALLET_ADDRESS_NO_EXISTS, Lang.getInstance().translate("address does not exist in wallet"));
		this.errorMessages.put(ERROR_WALLET_LOCKED, Lang.getInstance().translate("wallet is locked"));
		this.errorMessages.put(ERROR_WALLET_ALREADY_EXISTS, Lang.getInstance().translate("wallet already exists"));
		this.errorMessages.put(ERROR_WALLET_API_CALL_FORBIDDEN_BY_USER, Lang.getInstance().translate("user denied api call"));
		
		//BLOCK
		//this.errorMessages.put(ERROR_BLOCK_NO_EXISTS, Lang.getInstance().translate("block does not exist"));
		
		//TRANSACTIONS
		//this.errorMessages.put(ERROR_TRANSACTION_NO_EXISTS, Lang.getInstance().translate("transactions does not exist"));
		//this.errorMessages.put(ERROR_PUBLIC_KEY_NOT_FOUND, Lang.getInstance().translate("public key not found"));
		
		//NAMING
		//this.errorMessages.put(ERROR_NAME_NO_EXISTS, Lang.getInstance().translate("name does not exist"));
		//this.errorMessages.put(ERROR_NAME_ALREADY_EXISTS, Lang.getInstance().translate("name already exists"));
		//this.errorMessages.put(ERROR_NAME_ALREADY_FOR_SALE, Lang.getInstance().translate("name already for sale"));
		//this.errorMessages.put(ERROR_NAME_NOT_LOWER_CASE, Lang.getInstance().translate("name must be lower case"));
		//this.errorMessages.put(ERROR_NAME_SALE_NO_EXISTS, Lang.getInstance().translate("namesale does not exist"));
		//this.errorMessages.put(ERROR_BUYER_ALREADY_OWNER, Lang.getInstance().translate("buyer is already owner"));
		
		//POLLS
		//this.errorMessages.put(ERROR_POLL_NO_EXISTS, Lang.getInstance().translate("poll does not exist"));
		//this.errorMessages.put(ERROR_POLL_ALREADY_EXISTS, Lang.getInstance().translate("poll already exists"));
		//this.errorMessages.put(ERROR_DUPLICATE_OPTION, Lang.getInstance().translate("not all options are unique"));
		//this.errorMessages.put(ERROR_POLL_OPTION_NO_EXISTS, Lang.getInstance().translate("option does not exist"));
		//this.errorMessages.put(ERROR_ALREADY_VOTED_FOR_THAT_OPTION, Lang.getInstance().translate("already voted for that option"));
		
		//ASSETS
		//this.errorMessages.put(ERROR_INVALID_ASSET_ID, Lang.getInstance().translate("invalid asset id"));
		
		//NAME PAYMENTS
		//this.errorMessages.put(ERROR_NAME_NOT_REGISTERED, Lang.getInstance().translate(NameResult.NAME_NOT_REGISTERED.getStatusMessage()));
		//this.errorMessages.put(ERROR_NAME_FOR_SALE, Lang.getInstance().translate(NameResult.NAME_FOR_SALE.getStatusMessage()));
		//this.errorMessages.put(ERROR_NAME_WITH_SPACE, Lang.getInstance().translate(NameResult.NAME_WITH_SPACE.getStatusMessage()));
		
		//AT
		this.errorMessages.put(ERROR_INVALID_CREATION_BYTES, Lang.getInstance().translate("error in creation bytes"));
		this.errorMessages.put(ERROR_INVALID_DESC_LENGTH, Lang.getInstance().translate("invalid description length. max length ") + AT_Constants.DESC_MAX_LENGTH);
		this.errorMessages.put(ERROR_EMPTY_CODE, Lang.getInstance().translate("code is empty"));
		//this.errorMessages.put(ERROR_DATA_SIZE, Lang.getInstance().translate("invalid data length"));
		this.errorMessages.put(ERROR_INVALID_TYPE_LENGTH, Lang.getInstance().translate("invalid type length"));
		this.errorMessages.put(ERROR_INVALID_TAGS_LENGTH, Lang.getInstance().translate("invalid tags length"));
		this.errorMessages.put(ERROR_NULL_PAGES, Lang.getInstance().translate("invalid pages"));
		
		//BLOG
		this.errorMessages.put(ERROR_BODY_EMPTY, Lang.getInstance().translate("invalid body it must not be empty"));
		this.errorMessages.put(ERROR_BLOG_DISABLED, Lang.getInstance().translate("this blog is disabled"));
		this.errorMessages.put(ERROR_NAME_NOT_OWNER, Lang.getInstance().translate("the creator address does not own the author name"));
		this.errorMessages.put(ERROR_TX_AMOUNT, Lang.getInstance().translate("the data size is too large - currently only %BATCH_TX_AMOUNT% arbitrary transactions are allowed at once!").replace("%BATCH_TX_AMOUNT%", String.valueOf(BATCH_TX_AMOUNT)));
		this.errorMessages.put(ERROR_BLOG_ENTRY_NO_EXISTS, Lang.getInstance().translate("transaction with this signature contains no entries!"));
		this.errorMessages.put(ERROR_BLOG_EMPTY, Lang.getInstance().translate("this blog is empty"));
		this.errorMessages.put(ERROR_POSTID_EMPTY, Lang.getInstance().translate("the attribute postid is empty! this is the signature of the post you want to comment"));
		this.errorMessages.put(ERROR_POST_NOT_EXISTING, Lang.getInstance().translate("for the given postid no blogpost to comment was found"));
		this.errorMessages.put(ERROR_COMMENTING_DISABLED, Lang.getInstance().translate("commenting is for this blog disabled"));
		this.errorMessages.put(ERROR_COMMENT_NOT_EXISTING, Lang.getInstance().translate("for the given signature no comment was found"));
		this.errorMessages.put(ERROR_INVALID_COMMENT_OWNER, Lang.getInstance().translate("invalid comment owner"));
		
		
		//MESSAGES
		this.errorMessages.put(ERROR_MESSAGE_FORMAT_NOT_HEX, Lang.getInstance().translate("the Message format is not hex and not Base58 - correct the text or use isTextMessage = true"));
		//this.errorMessages.put(ERROR_MESSAGE_BLANK, Lang.getInstance().translate("The message attribute is missing or content is blank"));
		this.errorMessages.put(ERROR_NO_PUBLIC_KEY, Lang.getInstance().translate("The recipient has not yet performed any action in the blockchain.\nYou can't send an encrypted message to him."));
		//this.errorMessages.put(ERROR_MESSAGESIZE_EXCEEDED, Lang.getInstance().translate("Message size exceeded!"));

	}

	public String messageError(int error)
	{
		return this.errorMessages.get(error);
	}
	
	
	@SuppressWarnings("unchecked")
	public JSONObject createErrorJSON(int error)
	{

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("error", error);
		
		if ( error > ERROR )
		{
			// errors for API
			jsonObject.put("message", this.errorMessages.get(error) );
			
		} else if ( error > Transaction.AT_ERROR )
		{
			// AT errors
			jsonObject.put("message", AT_Error.getATError(error - Transaction.AT_ERROR) );
		}
		else
		{
			// errors for Transaction
			//jsonObject.put("message", this.errorMessages.get(error));
			jsonObject.put("message", OnDealClick.resultMess(error));
		}
		
		return jsonObject;
	}

	@SuppressWarnings("unchecked")
	public JSONObject createErrorJSON(String error)
	{

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("error", error);
				
		return jsonObject;
	}

	@SuppressWarnings("unchecked")
	public WebApplicationException createError(int error)
	{
		//return new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity(
		return new WebApplicationException(Response.status(Response.Status.OK).entity(
				createErrorJSON(error).toJSONString()).build());
	}

	@SuppressWarnings("unchecked")
	public WebApplicationException createError(String error)
	{
		//return new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity(
		return new WebApplicationException(Response.status(Response.Status.OK).entity(
				createErrorJSON(error).toJSONString()).build());
	}
}
