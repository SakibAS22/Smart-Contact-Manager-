console.log("Contact js");
const baseURL= "http://localhost:8082";
const viewContactModal= document.getElementById('view_contact_modal');

// option with default
const option={
    placement: "bottom-right",
    backdrop: "dynamic",
    backdropClasses:
        "bg-gray-900/50 dark:bg-gray-900/80 fixed inset-0 z-40",
    closable: true,
    onHide: ()=>{
        console.log("modal is hidden");
    },
    onShow: ()=>{
        console.log("modal is shown");
    },
    onToggle: ()=>{
        id:"view_contact_modal",
        console.log("modal has been toogled");
    }
};

// instance option object
const instanceOptions ={
    id:"view_contact_modal",
    override: true,
};

const contactModal= new Modal(viewContactModal, option, instanceOptions);

function openContactModal(){
    contactModal.show();
}

function closeContactModel(){
    contactModal.hide();
}

async function loadContactData(id){ 
        // function
    console.log(id);
   try {
     const data= await(await fetch(`${baseURL}/api/contacts/${id}`)).json()
    console.log(data);
    console.log(data.name);
    
    document.querySelector('#contact_name').innerHTML= data.name;
    document.querySelector('#contact_email').innerHTML= data.email;
    document.querySelector('#contact_image').src= data.picture;
        // ! image overlyaing
    const contactImage = document.querySelector('#contact_image');
    const overlay = document.querySelector('#image_overlay');
    const overlayImg = document.querySelector('#overlay_img');
    
    //! When clicking on small image → open overlay
    contactImage.addEventListener('click', () => {
        overlayImg.src = contactImage.src;
        overlay.classList.remove('hidden');
    });
    
    //! When clicking anywhere on overlay → close it
    overlay.addEventListener('click', () => {
        overlay.classList.add('hidden');
    });
    document.querySelector('#contact_number').innerHTML= data.phoneNumber;
    document.querySelector('#contact_address').innerHTML= data.address
    document.querySelector('#contact_description').innerHTML= data.description
    document.querySelector('#contact_webLink').href= data.websiteLink
    document.querySelector('#contact_webLink').innerHTML= data.websiteLink
    document.querySelector('#contact_linkedInLink').href= data.linkedInLink
    document.querySelector('#contact_linkedInLink').innerHTML= data.linkedInLink
    const isFavorite= data.favorite;
    if("Favorite: ",isFavorite){
        document.querySelector('#contact_isFavorite').innerHTML= "⭐⭐⭐⭐⭐";
        document.querySelector('#contact_isFavorite_row').style.display = 'table-row';
    }else{
        contact_isFavorite_row.style.display= 'none';
    }

;
    openContactModal();

   } catch (error) {
        console.log("Error: ",error);
            
   }
}

// ! delete contact

async function deleteContact(id){
    Swal.fire({
  title: "Do you want to delete the contact?",
  icon: "warning",
  showCancelButton: true,
  confirmButtonText: "Delete",
}).then((result) => {
  /* Read more about isConfirmed, isDenied below */
  if (result.isConfirmed) {
    const url= `${baseURL}/user/contacts/delete/`+id;
    window.location.replace(url);
  }
});
}