<%--
  Created by IntelliJ IDEA.
  User: andriypyzh
  Date: 14.02.2020
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=5.0,minimum-scale=1.0,shrink-to-fit=no">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta http-equiv="pragma" content="no-cache">
    <meta name="robots" content="index,follow">
    <meta name="author" content="codecalm.net">

    <link rel="sitemap" href="/sitemap.xml" type="application/xml">

    <title>Premium dashboard template with responsive and high quality UI - Tabler UI Kit</title>

    <meta name="description" content="Tabler comes with tons of well-designed components and features. Start your adventure with Tabler and make your dashboard great again. For free!">


    <!-- Google Tag Manager -->
    <script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
            new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
        j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
        'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
    })(window,document,'script','dataLayer','GTM-TX8M7DF');</script>
    <!-- End Google Tag Manager -->


    <style>
        *{-webkit-box-sizing:border-box;box-sizing:border-box}html{-ms-text-size-adjust:100%;-webkit-text-size-adjust:100%}*,body,input{text-rendering:optimizeLegibility;-webkit-font-smoothing:antialiased;-moz-osx-font-smoothing:grayscale}input{outline:0}body,html{-webkit-overflow-scrolling:touch}body{padding:0;margin:0}h1,h2,header,main,nav,p,section{padding:0;margin:0;display:block;-webkit-box-sizing:border-box;box-sizing:border-box;font-weight:400;font-size:inherit}a{background:0 0;text-decoration:none}img{border:0}svg:not(:root){overflow:hidden}input{color:inherit;font-size:inherit;margin:0;padding:0;font-family:Graphik Web,Helvetica Neue,Helvetica,Arial,Tahoma,sans-serif}input::-moz-focus-inner{border:0;padding:0}input::-webkit-contacts-auto-fill-button{display:none!important}::-ms-clear{display:none}::-webkit-input-placeholder{color:rgba(52,53,65,.6)}::-moz-placeholder{color:rgba(52,53,65,.6)}:-ms-input-placeholder{color:rgba(52,53,65,.6)}:-moz-placeholder{color:rgba(52,53,65,.6)}html{font-family:Rubik,Helvetica Neue,Helvetica,Arial,Tahoma,sans-serif;font-size:14px;scroll-behavior:smooth}@media (min-width:768px){html{font-size:15px}}@media (min-width:992px){html{font-size:16px}}body{font-size:1.0625rem;line-height:1.5;color:#343541;overflow-y:scroll}.header{background:#fff;border-bottom:1px solid rgba(0,0,0,.08);padding:1rem 0;font-size:1rem;position:absolute;top:0;left:0;right:0;z-index:1000;-webkit-box-shadow:0 1px 9px transparent;box-shadow:0 1px 9px transparent}.header.header-sticky{position:fixed;background-color:#fff;color:#343541;-webkit-box-shadow:0 1px 9px rgba(0,0,0,.05);box-shadow:0 1px 9px rgba(0,0,0,.05);opacity:0;-webkit-transform:translateY(-100%);transform:translateY(-100%)}@media (max-width:767.98px){.header.header-sticky{display:none}}.header-nav{display:-webkit-box;display:-ms-flexbox;display:flex;-webkit-box-orient:vertical;-webkit-box-direction:normal;-ms-flex-direction:column;flex-direction:column;z-index:3;right:0;position:absolute;top:100%;margin-top:.5rem;font-size:14px;-webkit-box-shadow:0 4px 8px 0 rgba(18,74,138,.24);box-shadow:0 4px 8px 0 rgba(18,74,138,.24)}@media (min-width:768px){.header-nav{-webkit-box-orient:horizontal;-webkit-box-direction:normal;-ms-flex-direction:row;flex-direction:row;-webkit-box-shadow:none;box-shadow:none;position:relative;margin-top:0}}@media (max-width:767.98px){.header-nav{background-color:#fff}.header-nav a{padding:.75rem 2rem}}.header-nav a:not(.btn){opacity:.8;color:inherit}@media (min-width:768px){.header-nav a+a{margin-left:1rem}}.header-menu-btn{display:-webkit-box;display:-ms-flexbox;display:flex;-webkit-box-align:center;-ms-flex-align:center;align-items:center;-webkit-box-pack:center;-ms-flex-pack:center;justify-content:center;height:2.5rem;width:2.5rem;margin-left:auto}@media (min-width:768px){.header-menu-btn{display:none;opacity:0}}.section{overflow:hidden;padding-top:4rem;padding-bottom:4rem}.section-title{margin:0 0 4rem}.page{display:-webkit-box;display:-ms-flexbox;display:flex;-webkit-box-orient:vertical;-webkit-box-direction:normal;-ms-flex-direction:column;flex-direction:column;outline:1px solid red;min-height:100vh}.main{-webkit-box-flex:1;-ms-flex:1;flex:1;padding-top:4rem}.logo{font-family:Quicksand,sans-serif;font-size:1.4375rem;font-weight:700;color:inherit;display:-webkit-inline-box;display:-ms-inline-flexbox;display:inline-flex;-webkit-box-align:center;-ms-flex-align:center;align-items:center;line-height:1;position:relative}.logo img{height:2rem;margin-right:.5rem}.welcome{padding:7rem 0 3rem;margin-top:-4rem;background:radial-gradient(rgba(248,250,252,.96) 80%,#f8fafc 100%),url(img/tabler-bg.svg) repeat center/1400px}@media (min-width:992px){.welcome{padding:13rem 0 9rem}}.welcome-title{color:inherit}.welcome-title{font-size:22px}@media screen and (min-width:576px){.welcome-title{font-size:calc(22px + 22 * (100vw - 576px)/ 704)}}@media screen and (min-width:1280px){.welcome-title{font-size:44px}}.welcome-description{opacity:.8;margin:2rem 0 0}.welcome-description{font-size:16px}@media screen and (min-width:576px){.welcome-description{font-size:calc(16px + 8 * (100vw - 576px)/ 704)}}@media screen and (min-width:1280px){.welcome-description{font-size:24px}}.welcome-blue{background:#4097e5 url(/img/header-blue.svg) no-repeat center/cover}.welcome-image{margin-bottom:-50rem;margin-top:-8rem;margin-left:3rem!important;position:relative}.welcome-image img{border:1px solid rgba(0,0,0,.04);border-radius:2px;position:relative;z-index:1}.welcome-image-2{margin:0!important}@media (min-width:992px){.welcome-image-2{margin-top:-3rem;margin-bottom:-3rem;margin-left:0!important}}.image-label{position:absolute;width:1px;height:1px;opacity:.5;z-index:2}.image-label span{position:absolute;right:0;top:0;display:block;font-family:"Indie Flower",cursive;color:#fff;font-size:1.125rem;width:15rem;text-align:right;line-height:1.1;-webkit-transform:rotate(-10deg);transform:rotate(-10deg);-webkit-transform-origin:top right;transform-origin:top right;padding-right:5rem;margin-top:-13px;padding-top:5px;background:url(img/arrow.svg) no-repeat right top/70px}.image-label-right span{padding-left:5rem;padding-right:0;right:auto;left:0;-webkit-transform-origin:top left;transform-origin:top left;-webkit-transform:rotate(6deg);transform:rotate(6deg);text-align:left;background:url(img/arrow-left.svg) no-repeat left top/70px}.image-label-bottom span{top:auto;bottom:0;-webkit-transform-origin:bottom right;transform-origin:bottom right;-webkit-transform:rotate(8deg);transform:rotate(8deg);margin-top:0;margin-bottom:-8px;padding-right:4.5rem;background:url(img/arrow-bottom.svg) no-repeat bottom right/60px}.container{width:100%;margin-right:auto;margin-left:auto;padding-right:1rem;padding-left:1rem}@media (min-width:576px){.container{max-width:540px}}@media (min-width:768px){.container{max-width:720px}}@media (min-width:992px){.container{max-width:960px}}@media (min-width:1280px){.container{max-width:1200px}}.row{display:-webkit-box;display:-ms-flexbox;display:flex;-ms-flex-wrap:wrap;flex-wrap:wrap;margin-right:-1rem;margin-left:-1rem}.col,.col-10,.col-12,.col-lg-5,.col-lg-6,.col-md-5{position:relative;width:100%;min-height:1px;padding-right:1rem;padding-left:1rem}.col{-ms-flex-preferred-size:0;flex-basis:0;-webkit-box-flex:1;-ms-flex-positive:1;flex-grow:1;max-width:100%}.col-10{-webkit-box-flex:0;-ms-flex:0 0 83.33333333%;flex:0 0 83.33333333%;max-width:83.33333333%}.col-12{-webkit-box-flex:0;-ms-flex:0 0 100%;flex:0 0 100%;max-width:100%}@media (min-width:768px){.col-md-5{-webkit-box-flex:0;-ms-flex:0 0 41.66666667%;flex:0 0 41.66666667%;max-width:41.66666667%}}@media (min-width:992px){.col-lg-5{-webkit-box-flex:0;-ms-flex:0 0 41.66666667%;flex:0 0 41.66666667%;max-width:41.66666667%}.col-lg-6{-webkit-box-flex:0;-ms-flex:0 0 50%;flex:0 0 50%;max-width:50%}}.mr-2{margin-right:1rem!important}.ml-2{margin-left:1rem!important}.mt-5{margin-top:3rem!important}.mb-5{margin-bottom:3rem!important}.mb-6{margin-bottom:4rem!important}.pt-6{padding-top:4rem!important}.ml-auto{margin-left:auto!important}@media (min-width:768px){.mb-md-0{margin-bottom:0!important}.pr-md-5{padding-right:3rem!important}}@media (min-width:992px){.pt-lg-0{padding-top:0!important}.pr-lg-5{padding-right:3rem!important}}.justify-content-center{-webkit-box-pack:center!important;-ms-flex-pack:center!important;justify-content:center!important}.justify-content-between{-webkit-box-pack:justify!important;-ms-flex-pack:justify!important;justify-content:space-between!important}.align-items-center{-webkit-box-align:center!important;-ms-flex-align:center!important;align-items:center!important}.d-none{display:none!important}.d-flex{display:-webkit-box!important;display:-ms-flexbox!important;display:flex!important}@media (min-width:768px){.d-md-block{display:block!important}}@media (min-width:1280px){.d-xl-block{display:block!important}}.h3,h1,h2{font-weight:500;line-height:1.25;margin:0 0 .25em}h1{font-size:3rem;letter-spacing:-.02em;color:#1d1f2c}h2{font-size:2.0625rem;letter-spacing:-.02em;color:#1d1f2c}.h3{font-size:1.6875rem}p{margin:0 0 1em}a{color:#1c7ed6;text-decoration:none}.preview-image{display:block;margin:0 auto;max-width:100%;border:0!important}input:-webkit-autofill{-webkit-box-shadow:0 0 0 30px #fff inset}.device-macbook-pro .device-frame{background:#0d0d0d;border-radius:20px;-webkit-box-shadow:inset 0 0 0 2px #c8cacb;box-shadow:inset 0 0 0 2px #c8cacb;margin:0 6%;padding:3.5% 3.5% 5%;position:relative}.device-macbook-pro .device-power{background:#e2e3e4;border:solid #d5d6d8;border-radius:2px 2px 0 0;border-width:2px 4px 0 4px;height:14px;margin-top:-8px;position:relative;z-index:9}.device-macbook-pro .device-power::after,.device-macbook-pro .device-power::before{content:"";position:absolute}.device-macbook-pro .device-power::after{background:#d5d6d8;border-radius:0 0 10px 10px;-webkit-box-shadow:inset 0 0 4px 2px #babdbf;box-shadow:inset 0 0 4px 2px #babdbf;height:10px;left:50%;margin-left:-60px;top:-2px;width:100px}.device-macbook-pro .device-power::before{background:#a0a3a7;border-radius:0 0 180px 180px/0 0 12px 12px;-webkit-box-shadow:inset 0 -2px 6px 0 #474a4d;box-shadow:inset 0 -2px 6px 0 #474a4d;height:12px;left:-4px;right:-4px;margin:0 auto;top:10px}.device-macbook-pro.device-spacegray .device-frame{-webkit-box-shadow:inset 0 0 0 2px #767a7d;box-shadow:inset 0 0 0 2px #767a7d}.device-macbook-pro.device-spacegray .device-power{background:#909496;border-color:#767a7d}.device-macbook-pro.device-spacegray .device-power::after{background:#83878a;-webkit-box-shadow:inset 0 0 4px 2px #6a6d70;box-shadow:inset 0 0 4px 2px #6a6d70}.device-macbook-pro.device-spacegray .device-power::before{background:#515456;-webkit-box-shadow:inset 0 -2px 6px 0 #000;box-shadow:inset 0 -2px 6px 0 #000}.btn{display:inline-block;background-color:#1c7ed6;color:#fff;font-size:1rem;font-family:inherit;font-weight:500;line-height:1.2;padding:.75rem 1.5rem;border-radius:2px;border:1px solid transparent}.btn-green{background-color:#5eba00}.btn-white{background-color:#fff;color:rgba(52,53,65,.8)}.text-white{color:#fff}.text-center{text-align:center}@media (min-width:992px){.text-lg-left{text-align:left}}.img-responsive{max-width:100%}.icon svg{height:1.75rem;width:1.75rem}.icon-gray{fill:rgba(52,53,65,.4)}.position-relative{position:relative!important}
    </style>
    <link rel="preload" href="/build/tabler-1568447964.min.css" as="style" onload="this.onload=null;this.rel='stylesheet'">
    <noscript><link rel="stylesheet" href="/build/tabler-1568447964.min.css"></noscript>




    <link rel="canonical" href="https://tabler.io/">

    <meta property="og:image" content="https://tabler.io/img/tabler/og.png?1568447964">
    <meta property="og:image:width" content="1536">
    <meta property="og:image:height" content="580">
    <meta property="og:type" content="website">
    <meta property="og:title" content="Premium dashboard template with responsive and high quality UI">
    <meta property="og:url" content="https://tabler.io/">
    <meta property="og:description" content="Tabler comes with tons of well-designed components and features. Start your adventure with Tabler and make your dashboard great again. For free!">



    <meta name="twitter:card" content="summary_large_image">
    <meta name="twitter:site" content="@codecalm">
    <meta name="twitter:creator" content="@codecalm">
    <meta name="twitter:title" content="Premium dashboard template with responsive and high quality UI">
    <meta name="twitter:description" content="Tabler comes with tons of well-designed components and features. Start your adventure with Tabler and make your dashboard great again. For free!">
    <meta name="twitter:image" content="https://tabler.io/img/tabler/og.png?1568447964">
    <link rel="shortcut icon" href="/icons/favicon.ico">
    <link rel="icon" type="image/png" sizes="16x16" href="/icons/favicon-16x16.png">
    <link rel="icon" type="image/png" sizes="32x32" href="/icons/favicon-32x32.png">
    <link rel="manifest" href="/icons/manifest.json">
    <meta name="mobile-web-app-capable" content="yes">
    <meta name="theme-color" content="#ffffff">
    <meta name="application-name" content="tabler">
    <link rel="apple-touch-icon" sizes="57x57" href="/icons/apple-touch-icon-57x57.png">
    <link rel="apple-touch-icon" sizes="60x60" href="/icons/apple-touch-icon-60x60.png">
    <link rel="apple-touch-icon" sizes="72x72" href="/icons/apple-touch-icon-72x72.png">
    <link rel="apple-touch-icon" sizes="76x76" href="/icons/apple-touch-icon-76x76.png">
    <link rel="apple-touch-icon" sizes="114x114" href="/icons/apple-touch-icon-114x114.png">
    <link rel="apple-touch-icon" sizes="120x120" href="/icons/apple-touch-icon-120x120.png">
    <link rel="apple-touch-icon" sizes="144x144" href="/icons/apple-touch-icon-144x144.png">
    <link rel="apple-touch-icon" sizes="152x152" href="/icons/apple-touch-icon-152x152.png">
    <link rel="apple-touch-icon" sizes="180x180" href="/icons/apple-touch-icon-180x180.png">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black-translucent">
    <meta name="apple-mobile-web-app-title" content="tabler">
    <link rel="apple-touch-startup-image" media="(device-width: 320px) and (device-height: 480px) and (-webkit-device-pixel-ratio: 1)" href="/icons/apple-touch-startup-image-320x460.png">
    <link rel="apple-touch-startup-image" media="(device-width: 320px) and (device-height: 480px) and (-webkit-device-pixel-ratio: 2)" href="/icons/apple-touch-startup-image-640x920.png">
    <link rel="apple-touch-startup-image" media="(device-width: 320px) and (device-height: 568px) and (-webkit-device-pixel-ratio: 2)" href="/icons/apple-touch-startup-image-640x1096.png">
    <link rel="apple-touch-startup-image" media="(device-width: 375px) and (device-height: 667px) and (-webkit-device-pixel-ratio: 2)" href="/icons/apple-touch-startup-image-750x1294.png">
    <link rel="apple-touch-startup-image" media="(device-width: 414px) and (device-height: 736px) and (orientation: landscape) and (-webkit-device-pixel-ratio: 3)" href="/icons/apple-touch-startup-image-1182x2208.png">
    <link rel="apple-touch-startup-image" media="(device-width: 414px) and (device-height: 736px) and (orientation: portrait) and (-webkit-device-pixel-ratio: 3)" href="/icons/apple-touch-startup-image-1242x2148.png">
    <link rel="apple-touch-startup-image" media="(device-width: 768px) and (device-height: 1024px) and (orientation: landscape) and (-webkit-device-pixel-ratio: 1)" href="/icons/apple-touch-startup-image-748x1024.png">
    <link rel="apple-touch-startup-image" media="(device-width: 768px) and (device-height: 1024px) and (orientation: portrait) and (-webkit-device-pixel-ratio: 1)" href="/icons/apple-touch-startup-image-768x1004.png">
    <link rel="apple-touch-startup-image" media="(device-width: 768px) and (device-height: 1024px) and (orientation: landscape) and (-webkit-device-pixel-ratio: 2)" href="/icons/apple-touch-startup-image-1496x2048.png">
    <link rel="apple-touch-startup-image" media="(device-width: 768px) and (device-height: 1024px) and (orientation: portrait) and (-webkit-device-pixel-ratio: 2)" href="/icons/apple-touch-startup-image-1536x2008.png">
    <link rel="icon" type="image/png" sizes="228x228" href="/icons/coast-228x228.png">
    <meta name="msapplication-TileColor" content="#ffffff">
    <meta name="msapplication-TileImage" content="/icons/mstile-144x144.png">
    <meta name="msapplication-config" content="/icons/browserconfig.xml">
    <link rel="yandex-tableau-widget" href="/icons/yandex-browser-manifest.json">

    <meta name="google-site-verification" content="BVFVRVpG6GoPMaAY6LsruG_pYia11RDrJGZtp0ITwA8">
    <meta name="google-site-verification" content="vy-dj7wuuTq0iblQEu2PIZ0OCH0pg4O63RrErzvLF_I">


</head>
<body>

<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-TX8M7DF" height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->


<div class="page">

    <header class="header js-header">
        <div class="container">
            <div class="d-flex align-items-center position-relative">
                <a href="/" class="logo">
                    <img src="/img/tabler.svg" alt="Tabler UI Kit" title="">

                    <div>
                        tabler

                    </div>

                </a>
                <a class="header-menu-btn">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-menu"><line x1="3" y1="12" x2="21" y2="12"></line><line x1="3" y1="6" x2="21" y2="6"></line><line x1="3" y1="18" x2="21" y2="18"></line></svg>
                </a>
                <nav class="ml-auto header-nav d-none d-md-block">

                    <a href="https://preview.tabler.io" rel="nofollow">Demo</a>
                    <a href="https://github.com/tabler/tabler" rel="nofollow">Source code</a>

                    <a href="/emails" rel="nofollow">Tabler Email</a>


                </nav>
            </div>
        </div>
    </header>
    <header class="header header-sticky js-header">
        <div class="container">
            <div class="d-flex align-items-center position-relative">
                <a href="/" class="logo header-sticky">
                    <img src="/img/tabler.svg" alt="Tabler UI Kit" title="">

                    <div>
                        tabler

                    </div>

                </a>
                <a class="header-menu-btn">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-menu"><line x1="3" y1="12" x2="21" y2="12"></line><line x1="3" y1="6" x2="21" y2="6"></line><line x1="3" y1="18" x2="21" y2="18"></line></svg>
                </a>
                <nav class="ml-auto header-nav d-none d-md-block">

                    <a href="https://preview.tabler.io" rel="nofollow">Demo</a>
                    <a href="https://github.com/tabler/tabler" rel="nofollow">Source code</a>

                    <a href="/emails" rel="nofollow">Tabler Email</a>


                </nav>
            </div>
        </div>
    </header>

    <main class="main">
        <section class="welcome welcome-blue text-white" aria-label="Page header">
            <div class="container">
                <div class="row align-items-center justify-content-between">
                    <div class="col-lg-6 text-center text-lg-left pr-lg-5">
                        <h1 class="welcome-title">Admin panel made simple. For Free!</h1>
                        <p class="welcome-description">
                            Premium and Open Source dashboard template with responsive and high quality UI.
                        </p>

                        <div class="mt-5">
                            <a href="https://gum.co/tabler" class="btn btn-green">Download</a>
                            <a href="https://preview.tabler.io" class="btn btn-white ml-2">Browse demo</a>
                        </div>
                    </div>
                    <div class="col-lg-5 pt-6 pt-lg-0">
                        <div class="welcome-image welcome-image-2">

                            <div class="device device-macbook-pro device-spacegray">
                                <div class="device-frame">
                                    <picture>
                                        <source srcset="/img/dashboard-preview.webp" type="image/webp">
                                        <source srcset="/img/dashboard-preview.png" type="image/png">
                                        <img src="/img/dashboard-preview.png" alt="Preview of tabler dashboard" class="preview-image img-responsive">
                                    </picture>
                                </div>
                                <div class="device-stripe"></div>
                                <div class="device-header"></div>
                                <div class="device-sensors"></div>
                                <div class="device-btns"></div>
                                <div class="device-power"></div>
                            </div>

                            <div style="bottom: 15%; left: 3%" class="image-label image-label-bottom d-none d-xl-block"><span>For free!</span></div>
                            <div style="top: 20%; right: 3%" class="image-label image-label-right d-none d-xxl-block"><span>Look great in every browser</span></div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <section class="section" aria-label="Base features">
            <div class="container">
                <h2 class="h3 section-title text-center mb-6">Tabler comes with tons of<br>well-designed components and features.</h2>

                <div class="row align-items-center justify-content-center">
                    <div class="col-10 col-md-5 pr-md-5 mb-5 mb-md-0">

                        <picture>
                            <source srcset="/img/tabler-features.webp" type="image/webp">
                            <source srcset="/img/tabler-features.png" type="image/jpeg">
                            <img src="/img/tabler-features.png" alt="" class="img-responsive">
                        </picture>
                    </div>
                    <div class="col">

                        <div class="row">

                            <div class="col-12 mb-5 d-flex">
                                <div class="icon icon-gray mr-2">
                                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 256 256"><path d="M216.8 0H40v192H0v64h256v-64h-39.2V0zm-16 240H75.2l68-104L64 16h137.6v224h-.8zM124 136L56 239.2V33.6L124 136zM16 208h24v32H16v-32zm224 0v32h-23.2v-32H240z"/><path d="M160 32h16v64h-16z"/></svg>
                                </div>
                                <div>
                                    <h3 class="h5">Coded by Developers for Developers</h3>
                                    <p class="text-muted m-0">
                                        Clear and telling code that you won't get lost in. It was made with care and loves so that you don't have to spend hours on making it work ❤️
                                    </p>
                                </div>
                            </div>

                            <div class="col-12 mb-5 d-flex">
                                <div class="icon icon-gray mr-2">
                                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 256 232"><path d="M132.8 32h-1.6V0H112L43.2 72.8v22.4L112 168h19.2v-32H144c52.8 0 96 43.2 96 96h16v-76.8C256 87.2 200.8 32 132.8 32zM240 174.4c-20-33.6-56.8-54.4-96-54.4h-28.8v28l-56-59.2v-9.6l56-59.2v28h17.6C192 48 240 96 240 155.2v19.2z"/><path d="M16 77.6L78.4 12 67.2.8 0 71.2v25.6L75.2 176l12-11.2L16 90.4z"/></svg>
                                </div>
                                <div>
                                    <h3 class="h5">Open Source Code</h3>
                                    <p class="text-muted m-0">
                                        You can see the code of Tabler on its GitHub account. If you miss any feature feel free to create a pull request there, we'll definitely check it.
                                    </p>
                                </div>
                            </div>

                            <div class="col-12 mb-5 d-flex">
                                <div class="icon icon-gray mr-2">
                                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 256 240"><path d="M216 120c-8.8 0-16.8 3.2-24 8-17.6-13.6-42.4-9.6-56 8-12 16-10.4 37.6 3.2 52l48.8 52h8l51.2-55.2c5.6-7.2 8.8-16 8.8-24.8 0-22.4-17.6-40-40-40zm19.2 54.4L192 220.8l-40.8-44c-9.6-9.6-9.6-24.8 0-33.6 9.6-9.6 24.8-9.6 33.6 0 .8.8.8.8.8 1.6l6.4 7.2 6.4-7.2c4.8-5.6 11.2-8 17.6-8 13.6 0 24 10.4 24 24 0 4.8-1.6 9.6-4.8 13.6z"/><path d="M112 144H16V24l112 73.6 112-74.4V112h16V0H0v160h112v-16zm16-65.6L33.6 16h188.8L128 78.4z"/></svg>
                                </div>
                                <div>
                                    <h3 class="h5">Build with Bootstrap</h3>
                                    <p class="text-muted m-0">
                                        Tabler used Bootstrap, the most popular HTML, CSS, and JS framework. Thanks to this developers without experience can modify code without any problems
                                    </p>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>

                <!--<div class="mb-xl-4 text-center text-lg-left">-->
                <!--<a href="#" class="btn btn-white">See all features</a>-->
                <!--</div>-->
            </div>
        </section>

        <section class="section text-center bg-light" aria-label="Ben Chestnut quote">
            <div class="container">
                <div>
                    <blockquote>
                        <div>
                            <img src="/img/bilal-budhani.jpg" alt="" class="avatar">
                            <p>“This is really good. I've already started using this in one of the projects where we are in the phase of rebuilding the admin's dashboard. Good job!”</p>
                        </div>
                        <cite><strong>Bilal Budhani</strong>, CEO of <strong>bilal.dev</strong></cite>
                    </blockquote>
                </div>
            </div>
        </section>

        <section class="section">
            <div class="container">
                <div class="row">
                    <div class="col-md-6 pr-md-7">
                        <h3 class="h4 mb-1">Subscribe for Updates</h3>
                        <p class="text-muted"> Stay in touch with us. We will send you info about each of the major updates.</p>

                        <form action="https://gumroad.com/follow_from_embed_form" class="form d-flex gumroad-follow-form-embed" method="post" target="_blank">
                            <input name="seller_id" type="hidden" value="5903833945199">
                            <input name="email" placeholder="Your email address" type="email" class="form-input">
                            <button data-custom-highlight-color="" type="submit" class="btn btn-blue ml-2">Subscribe</button>
                        </form>
                    </div>

                    <div class="col-md-6 mt-5 mt-md-0">
                        <h3 class="h4 mb-1">Latest Posts</h3>

                        <ul class="list">


                            <li><a href="/customer-service-email.html" title="Best practices connected with customer service" class="text-inherit">Customer service email</a></li>

                            <li><a href="/html-email-best-practices.html" title="10 most important things which you should keep in mind by coding HTML emails" class="text-inherit">HTML email best practices</a></li>

                            <li><a href="/reset-password-good-practise.html" title="What should be included in reset password email" class="text-inherit">What you should remember while designing reset password email</a></li>

                            <li><a href="/responsive-emails.html" title="Best practices connected with creating responsive email messages" class="text-inherit">How to create responsive email</a></li>

                            <li><a href="/user-invitation-email.html" title="What an email with user’s invitation should include" class="text-inherit">User invitation good practises</a></li>

                        </ul>
                    </div>
                </div>
            </div>
        </section>

        <section class="section bg-light">
            <div class="container text-center">
                <h2 class="section-title mb-2">Ready to download?</h2>
                <p class="section-description">
                    Start your adventure with Tabler and make your dashboard great again. For free!</p>
                <div class="mt-4">
                    <a href="https://gum.co/tabler" class="btn btn-green" target="_blank">Download</a>
                    <a href="https://preview.tabler.io" class="btn btn-secondary ml-2">See demo</a>
                </div>
            </div>
        </section>


    </main>

    <footer class="footer">
        <div class="container">
            <div class="row text-center text-lg-left">
                <div class="col-lg-6">
                    <p>© 2018 Project maintained by <a href="https://codecalm.net" class="text-inherit">codecalm.net</a></p>
                </div>
                <div class="col-lg-6 text-lg-right">
                    <a href="/privacy-policy.html">Privacy Policy</a>
                    <a href="/terms-of-service.html">Terms of usage</a>
                </div>
            </div>
        </div>
    </footer>

</div>

<script src="/build/tabler-1568447964.min.js" async></script>

<style>
    @import url("https://fonts.googleapis.com/css?family=Rubik:400,400i,500,600,700|Quicksand:700|Indie+Flower:400");
</style>


<script>
    if('serviceWorker' in navigator) {
        // navigator.serviceWorker
        // 	.register('/sw.js')
        // 	.then(function() {
        // 		console.log("Service Worker Registered");
        // 	});
    }
</script>
<!-- Yandex.Metrika counter -->
<script type="text/javascript">
    (function (d, w, c) {
        (w[c] = w[c] || []).push(function() {
            try {
                w.yaCounter51402697 = new Ya.Metrika2({
                    id:51402697,
                    clickmap:true,
                    trackLinks:true,
                    accurateTrackBounce:true
                });
            } catch(e) { }
        });

        var n = d.getElementsByTagName("script")[0],
            s = d.createElement("script"),
            f = function () { n.parentNode.insertBefore(s, n); };
        s.type = "text/javascript";
        s.async = true;
        s.src = "https://mc.yandex.ru/metrika/tag.js";

        if (w.opera == "[object Opera]") {
            d.addEventListener("DOMContentLoaded", f, false);
        } else { f(); }
    })(document, window, "yandex_metrika_callbacks2");
</script>
<noscript><div><img src="https://mc.yandex.ru/watch/51402697" style="position:absolute; left:-9999px;" alt=""></div></noscript>
<script>!function(n){"use strict";n.loadCSS||(n.loadCSS=function(){});var o=loadCSS.relpreload={};if(o.support=function(){var e;try{e=n.document.createElement("link").relList.supports("preload")}catch(t){e=!1}return function(){return e}}(),o.bindMediaToggle=function(t){var e=t.media||"all";function a(){t.addEventListener?t.removeEventListener("load",a):t.attachEvent&&t.detachEvent("onload",a),t.setAttribute("onload",null),t.media=e}t.addEventListener?t.addEventListener("load",a):t.attachEvent&&t.attachEvent("onload",a),setTimeout(function(){t.rel="stylesheet",t.media="only x"}),setTimeout(a,3e3)},o.poly=function(){if(!o.support())for(var t=n.document.getElementsByTagName("link"),e=0;e<t.length;e++){var a=t[e];"preload"!==a.rel||"style"!==a.getAttribute("as")||a.getAttribute("data-loadcss")||(a.setAttribute("data-loadcss",!0),o.bindMediaToggle(a))}},!o.support()){o.poly();var t=n.setInterval(o.poly,500);n.addEventListener?n.addEventListener("load",function(){o.poly(),n.clearInterval(t)}):n.attachEvent&&n.attachEvent("onload",function(){o.poly(),n.clearInterval(t)})}"undefined"!=typeof exports?exports.loadCSS=loadCSS:n.loadCSS=loadCSS}("undefined"!=typeof global?global:this);</script>
<!-- /Yandex.Metrika counter -->


</body>
</html>