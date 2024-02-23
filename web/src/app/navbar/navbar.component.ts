import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit{
  ngOnInit(): void {

    // $(document).scroll(function(e:any){
    //   let nav = $("#zsnav");
    //   console.log("🚀 ~ NavbarComponent ~ $ ~ nav:", nav)
    //   let scrollTop : number = $(e.target).scrollTop()!;
    //   console.log("🚀 ~ NavbarComponent ~ $ ~ scrollTop:", scrollTop)

    //   if (scrollTop > 524) {
    //     console.log("🚀 ~ NavbarComponent ~ $ ~ scrollTopIF:", scrollTop > 650);
    //     $("#zsnav").addClass('scrolled');
    //   }else{
    //     $("#zsnav").removeClass('scrolled');
    //   }

    // });
    
    $('.zsnav.navbar .navbar-collapse .navbar-nav .nav-item ').click(function(e:any){
      let linkActive = $('.zsnav.navbar .navbar-collapse .navbar-nav .nav-item .active');
      linkActive.removeClass('active');
      $(e.target).addClass('active');

      let divID : string = $(e.target).attr("ref")!;

      $('html, body').animate({
        scrollTop: $(divID).offset()!.top - 72
      }, 0);

    });

    $('.zsnav.navbar .navbar-brand ').click(function (e: any) {

      let divID: string = $(e.target).attr("ref")!;

      $('html, body').animate({
        scrollTop: $(divID).offset()!.top - 72
      }, 0);

    });

  }
  title = "ZarSoft";
  logo = "assets/logos/logo_transparente.png"
}
