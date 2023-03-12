# Communication-between-applications-simple
This repository is an example of communication between different applications by sending broadcast messages.

## Project modules

### [:accepter] 
The module in which the exo receiver is located, when receiving data by the desired key, outputs them to logCat. To send messages to this receiver, you need a permission that is declared in the manifest of this module.


### [:sender] 
This module sends a message to the exo receiver which is located in the module [:accepter]. This module has the permission required for sending.

### [:fakehacker]
This module simulates an attacker who wants to gain access to the receiver in [:accepter], which is not allowed to him.

### [:SendExoBroadcastUseCase]
In this module, find the use case to send a message to the receiver, which is located in [:accepter]

### [:Share]
This module store shared constants

## Additional information
Permission to send a message to the receiver, which is located in [:accepter], has protectionlevel="signature", which means that in order to receive this permission, in addition to specifying this permission in the manifest, applications must be signed with one signature. 
This means that for example:
You have an application [:accepter]  and [:sender] and they have a debug signature. Since the permission is specified in the manifest of the [:sender] application and they are signed with one key, the system will give access to the receiver located in [:accepter] .

If we assume we are from the application [:fakehaker] which is also signed debug, we will send a message to the receiver, then the system will not allow this to be done because the required permission is not specified in the manifest.  Also, the system will not allow access to the receiver if the applications have different signatures (for example, [:accepter] is signed with a debug signature, and [:fakehacker] with a release signature), even though we will indicate the permission in the manifest.

I hope you understand my explanation )
