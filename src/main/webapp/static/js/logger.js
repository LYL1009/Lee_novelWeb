var bdShare = bdShare || {};
bdShare._LogPool = bdShare._LogPool || [], bdShare.ApiPVLogger || function (e) {
    function u(e, t) {
        var n = [];
        for (var r in t) {
            var i = typeof t[r];
            i != "function" && i != "object" && t.hasOwnProperty(r) && n.push(e + "_" + r + "=" + t[r])
        }
        return n.join("&")
    }

    function a() {
        var e = bdShare._LogPool || [], t = {};
        for (var n = e.length - 1; n >= 0; n--) {
            var r = e[n], i = t[r.key];
            i ? (i.linkid = i.linkid || r.api.linkid, i.type = (i.type || 0) | (r.api.type || 0)) : t[r.key] = r.api
        }
        e = [];
        for (var s in t) t.hasOwnProperty(s) && e.push({key: s, api: t[s]});
        return bdShare._LogPool = e, e
    }

    function f() {
        var e = bdShare._LogPool || [], t = e.length;
        if (t > 0) {
            e = a(), t = e.length;
            var n = [], i = "", s = null, f = [0, 0, 0, 0, 0, 0, 0, 0];
            for (var l = 0; l < t; l++) s = e[l], f[r[s.key]] = 1, s.api.linkid && (i = s.api.linkid, delete s.api.linkid), n.push(u(s.key, s.api));
            n.unshift("linkid=" + i), n.unshift("apitype=" + parseInt(f.reverse().join(""), 2)), o(n.join("&"))
        }
    }

    function c() {
        l = !0, t.dom.ready(function () {
            setTimeout(function () {
                p(), h()
            }, 1e3)
        })
    }

    var t, n = t = n || {version: "1.5.2.2"};
    n.guid = "$BAIDU$", n.$$ = window[n.guid] = window[n.guid] || {global: {}}, n.ajax = n.ajax || {}, n.fn = n.fn || {}, n.fn.blank = function () {
    }, n.ajax.request = function (e, t) {
        function v() {
            if (d.readyState == 4) {
                try {
                    var e = d.status
                } catch (t) {
                    g("failure");
                    return
                }
                g(e), e >= 200 && e < 300 || e == 304 || e == 1223 ? g("success") : g("failure"), window.setTimeout(function () {
                    d.onreadystatechange = n.fn.blank, s && (d = null)
                }, 0)
            }
        }

        function m() {
            if (window.ActiveXObject) try {
                return new ActiveXObject("Msxml2.XMLHTTP")
            } catch (e) {
                try {
                    return new ActiveXObject("Microsoft.XMLHTTP")
                } catch (e) {
                }
            }
            if (window.XMLHttpRequest) return new XMLHttpRequest
        }

        function g(e) {
            e = "on" + e;
            var t = c[e], r = n.ajax[e];
            if (t) {
                h && clearTimeout(h);
                if (e != "onsuccess") t(d); else {
                    try {
                        d.responseText
                    } catch (i) {
                        return t(d)
                    }
                    t(d, d.responseText)
                }
            } else if (r) {
                if (e == "onsuccess") return;
                r(d)
            }
        }

        var r = t || {}, i = r.data || "", s = r.async !== !1, o = r.username || "", u = r.password || "",
            a = (r.method || "GET").toUpperCase(), f = r.headers || {}, l = r.timeout || 0, c = {}, h, p, d;
        for (p in r) c[p] = r[p];
        f["X-Requested-With"] = "XMLHttpRequest";
        try {
            d = m(), a == "GET" && (i && (e += (e.indexOf("?") >= 0 ? "&" : "?") + i, i = null), r.noCache && (e += (e.indexOf("?") >= 0 ? "&" : "?") + "b" + +(new Date) + "=1")), o ? d.open(a, e, s, o, u) : d.open(a, e, s), s && (d.onreadystatechange = v), a == "POST" && d.setRequestHeader("Content-Type", f["Content-Type"] || "application/x-www-form-urlencoded");
            for (p in f) f.hasOwnProperty(p) && d.setRequestHeader(p, f[p]);
            g("beforerequest"), l && (h = setTimeout(function () {
                d.onreadystatechange = n.fn.blank, d.abort(), g("timeout")
            }, l)), d.send(i), s || v()
        } catch (y) {
            g("failure")
        }
        return d
    }, n.browser = n.browser || {}, function () {
        var e = navigator.userAgent;
        n.browser.safari = /(\d+\.\d)?(?:\.\d)?\s+safari\/?(\d+\.\d+)?/i.test(e) && !/chrome/i.test(e) ? +(RegExp.$1 || RegExp.$2) : undefined
    }(), n.browser.ie = n.ie = /msie (\d+\.\d+)/i.test(navigator.userAgent) ? document.documentMode || +RegExp.$1 : undefined, n.browser.opera = /opera(\/| )(\d+(\.\d+)?)(.+?(version\/(\d+(\.\d+)?)))?/i.test(navigator.userAgent) ? +(RegExp.$6 || RegExp.$2) : undefined, n.dom = n.dom || {}, function () {
        var e = n.dom.ready = function () {
            function r() {
                if (!r.isReady) {
                    r.isReady = !0;
                    for (var e = 0, n = t.length; e < n; e++) t[e]()
                }
            }

            function i() {
                try {
                    document.documentElement.doScroll("left")
                } catch (e) {
                    setTimeout(i, 1);
                    return
                }
                r()
            }

            function s() {
                if (e) return;
                e = !0;
                if (document.readyState === "complete") r.isReady = !0; else if (document.addEventListener) document.addEventListener("DOMContentLoaded", n, !1), window.addEventListener("load", r, !1); else if (document.attachEvent) {
                    document.attachEvent("onreadystatechange", n), window.attachEvent("onload", r);
                    var t = !1;
                    try {
                        t = window.frameElement == null
                    } catch (s) {
                    }
                    document.documentElement.doScroll && t && i()
                }
            }

            var e = !1, t = [], n;
            return document.addEventListener ? n = function () {
                document.removeEventListener("DOMContentLoaded", n, !1), r()
            } : document.attachEvent && (n = function () {
                document.readyState === "complete" && (document.detachEvent("onreadystatechange", n), r())
            }), s(), function (e) {
                r.isReady ? e() : t.push(e)
            }
        }();
        e.isReady = !1
    }(), t.undope = !0;
    var r = {cite: 0, img: 1, addto: 2, video: 3}, i = window.location || document.location, s = function () {
        var e = [];
        return function (t) {
            var n = "bdsharelog__" + (new Date).getTime(), r = e[n] = new Image;
            r.onload = r.onerror = function () {
                e[n] = null
            }, r.src = t, r = null
        }
    }(), o = function (e) {
        var t = document.body.offsetWidth, n = document.body.offsetHeight, r = window.screen.availWidth,
            i = window.screen.availHeight, o = [t, n, r, i].join(","),
            u = "http://nsclick.baidu.com/v.gif?pid=307&type=3071&sc=" + o + "&desturl=" + encodeURIComponent(document.referrer) + "&";
        s(u + e)
    }, l = !1, h = function () {
        var e = +(new Date), n = {spendTime: 0, scrollTop: 0, viewHeight: 0}, r = +(new Date), i = function () {
            var e = new Date - r;
            if (e > n.spendTime) {
                var t = document.compatMode == "BackCompat" ? document.body : document.documentElement;
                n = {
                    spendTime: e,
                    scrollTop: window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop,
                    viewHeight: t.clientHeight
                }
            }
            r = new Date
        }, o = function (e, t, n) {
            e.addEventListener ? e.addEventListener(t, n, !1) : e.attachEvent && e.attachEvent("on" + t, n)
        }, u = 0, a = 1e3;
        setInterval(function () {
            document.hasFocus() && u++
        }, a), o(window, "scroll", i), o(window, "beforeunload", function () {
            var r = new Date - e;
            if (r == 0) return;
            i();
            var o = ["http://nsclick.baidu.com/v.gif?pid=307", "type=3075", "l=" + r, "t=" + n.scrollTop, "s=" + n.spendTime, "v=" + n.viewHeight, "f=" + u * a, "r=" + encodeURIComponent(document.referrer), "u=" + encodeURIComponent(window.location.href)].join("&");
            /firefox\/(\d+\.\d+)/i.test(navigator.userAgent) ? t.ajax.request(o, {async: !1, timeout: 300}) : s(o)
        })
    }, p = function () {
        var e = 0;
        return function () {
            if (bdShare.velocity && (!bdShare.velocity.mainJsLoaded || !bdShare.velocity.cssLoadEnd) && e++ < 3) setTimeout(p, 1e3); else {
                if (bdShare.velocity) {
                    var t = Math.max(bdShare.velocity.cssLoadEnd, bdShare.velocity.mainJsLoaded) - bdShare.velocity.start || 0,
                        n = bdShare.velocity.cssLoadEnd - bdShare.velocity.cssLoadStart || 0,
                        r = bdShare.velocity.mainJsLoaded - bdShare.velocity.start || 0;
                    bdShare._LogPool.length > 0 && bdShare._LogPool.push({
                        key: "velo",
                        api: {load: t, cssload: n, jsLoad: r}
                    })
                }
                f()
            }
        }
    }();
    e.ApiPVLogger = {
        add: function (e, t) {
            bdShare._LogPool.push({key: e, api: t})
        }
    }, l || c()
}(bdShare);